package com.example.myandroid.ui.covid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.myandroid.MainCoroutineRule
import com.example.myandroid.data.covid.CovidRepository
import com.example.myandroid.data.covid.TimeLineCasesAllResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@ExperimentalCoroutinesApi
class CovidViewModelTest {

    /**
     * A JUnit Test Rule that swaps the background executor used by the Architecture Components
     * with a different one which executes each task synchronously.
     * You can use this rule for your host side tests that use Architecture Components.
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val covidRepository: CovidRepository = mock()

    private val loadingObserver: Observer<Boolean> = mock()
    private val errorDialogObserver: Observer<String> = mock()
    private val displayTimeLineCasesObserver: Observer<List<TimeLineCasesAllResponse>> = mock()

    private lateinit var viewModel: CovidViewModel

    @Before
    fun setUp() {
        viewModel = CovidViewModel(covidRepository)

        viewModel.loading.observeForever(loadingObserver)
        viewModel.errorDialog.observeForever(errorDialogObserver)
        viewModel.displayTimeLineCases.observeForever(displayTimeLineCasesObserver)
    }

    @Test
    fun `executeGetTimeLineCasesAll - display covid time line all cases when success`() {
        // given
        val timeLine1 = TimeLineCasesAllResponse(
            txnDate = "2021-08-17",
            newCase = 20128,
            totalCase = 948442,
            updateDate = "2021-08-17 07:38:13"
        )
        val timeLine2 = TimeLineCasesAllResponse(
            txnDate = "2021-08-18",
            newCase = 20515,
            totalCase = 968957,
            updateDate = "2021-08-18 07:39:34"
        )
        val casesExpected = listOf(
            timeLine2,
            timeLine1,
        )
        val response = listOf(timeLine1, timeLine2)
        given { covidRepository.getTimeLineCasesAll() }.willReturn(flowOf(response))

        // when
        viewModel.executeGetTimeLineCasesAll()

        // then
        verify(loadingObserver).onChanged(true)
        verify(loadingObserver).onChanged(false)
        verify(displayTimeLineCasesObserver).onChanged(casesExpected)
    }

    @Test
    fun `executeGetTimeLineCasesAll - error dialog when error`() {
        // given
        val error = Exception("error naja")
        given { covidRepository.getTimeLineCasesAll() }.willReturn(flow { throw error })

        // when
        viewModel.executeGetTimeLineCasesAll()

        // then
        verify(loadingObserver).onChanged(true)
        verify(loadingObserver).onChanged(false)
        verify(errorDialogObserver).onChanged("error naja")
    }
}
