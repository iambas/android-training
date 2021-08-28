package com.example.myandroid.ui.architecture

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ArchitectureViewModelTest {

    /**
     * A JUnit Test Rule that swaps the background executor used by the Architecture Components
     * with a different one which executes each task synchronously.
     * You can use this rule for your host side tests that use Architecture Components.
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    /**
     * mock observer
     */
    private val resultObserver: Observer<String> = mock()

    private lateinit var viewModel: ArchitectureViewModel

    /**
     * set up test
     */
    @Before
    fun setUp() {
        viewModel = ArchitectureViewModel()

        // set up observer
        viewModel.result.observeForever(resultObserver)
    }

    @Test
    fun calculateBMI() {
        viewModel.weight.value = "55"
        viewModel.height.value = "180"
        Assert.assertEquals(16.98, viewModel.calculateBMI(), 0.0)

        viewModel.weight.value = "60"
        viewModel.height.value = "170"
        Assert.assertEquals(20.77, viewModel.calculateBMI(), 0.0)

        viewModel.weight.value = "60"
        viewModel.height.value = "160"
        Assert.assertEquals(23.44, viewModel.calculateBMI(), 0.0)

        viewModel.weight.value = "60"
        viewModel.height.value = "155"
        Assert.assertEquals(24.98, viewModel.calculateBMI(), 0.0)

        viewModel.weight.value = "80"
        viewModel.height.value = "155"
        Assert.assertEquals(33.3, viewModel.calculateBMI(), 0.0)
    }

    @Test
    fun `onCalculateButtonClicked - BMI less than 18 dot 5 is thin`() {
        // given
        viewModel.weight.value = "55"
        viewModel.height.value = "180"

        // when
        viewModel.onCalculateButtonClicked()

        // then
        verify(resultObserver).onChanged("น้ำหนักน้อย / ผอม")
    }

    @Test
    fun `onCalculateButtonClicked - BMI less than 22 dot 9 is normal`() {
        // given
        viewModel.weight.value = "60"
        viewModel.height.value = "170"

        // when
        viewModel.onCalculateButtonClicked()

        // then
        verify(resultObserver).onChanged("ปกติ (สุขภาพดี)")
    }

    @Test
    fun `onCalculateButtonClicked - BMI less than 24 dot 9 is fat level 1`() {
        // given
        viewModel.weight.value = "60"
        viewModel.height.value = "160"

        // when
        viewModel.onCalculateButtonClicked()

        // then
        verify(resultObserver).onChanged("ท้วม / โรคอ้วนระดับ 1")
    }

    @Test
    fun `onCalculateButtonClicked - BMI less than 29 dot 9 is fat level 2`() {
        // given
        viewModel.weight.value = "60"
        viewModel.height.value = "155"

        // when
        viewModel.onCalculateButtonClicked()

        // then
        verify(resultObserver).onChanged("อ้วน / โรคอ้วนระดับ 2")
    }

    @Test
    fun `onCalculateButtonClicked - BMI more than 30 is fat level 3`() {
        // given
        viewModel.weight.value = "80"
        viewModel.height.value = "155"

        // when
        viewModel.onCalculateButtonClicked()

        // then
        verify(resultObserver).onChanged("อ้วนมาก / โรคอ้วนระดับ 3")
    }
}
