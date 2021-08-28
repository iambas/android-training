package com.example.myandroid.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    protected val tag: String
        get() = this::class.java.simpleName

    private val _loading by lazy { MutableLiveData<Boolean>() }
    val loading: LiveData<Boolean> get() = _loading

    private val _errorDialog by lazy { MutableLiveData<String>() }
    val errorDialog: LiveData<String> get() = _errorDialog

    fun showLoading() {
        _loading.postValue(true)
    }

    fun hideLoading() {
        _loading.postValue(false)
    }

    fun showErrorDialog(throwable: Throwable) {
        _errorDialog.postValue(throwable.message)
    }

    fun showErrorDialog(message: String?) {
        _errorDialog.postValue(message)
    }
}
