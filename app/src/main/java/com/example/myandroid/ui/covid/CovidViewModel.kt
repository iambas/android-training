package com.example.myandroid.ui.covid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myandroid.data.covid.CovidRepository
import com.example.myandroid.data.covid.TimeLineCasesAllResponse
import com.example.myandroid.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CovidViewModel constructor(
    private val covidRepository: CovidRepository
) : BaseViewModel() {

    private val _displayTimeLineCases by lazy { MutableLiveData<List<TimeLineCasesAllResponse>>() }
    val displayTimeLineCases: LiveData<List<TimeLineCasesAllResponse>> get() = _displayTimeLineCases

    fun executeGetTimeLineCasesAll() {
        viewModelScope.launch {
            covidRepository.getTimeLineCasesAll()
                .onStart {
//                    Log.d(tag, "flow onStart")
                    showLoading()
                }
                .onCompletion {
//                    Log.d(tag, "flow onCompletion")
                    hideLoading()
                }
                .catch {
//                    Log.e(tag, "flow catch: ${it.message}")
                    showErrorDialog(it)
                }
                .collect {
//                    Log.d(tag, "flow collect: $it")
                    // TODO: reverse list
                    _displayTimeLineCases.postValue(it)
                }
        }
    }
}
