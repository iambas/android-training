package com.example.myandroid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myandroid.ui.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    private val _navigateToLinearLayout by lazy { MutableLiveData<Unit>() }
    val navigateToLinearLayout: LiveData<Unit> get() = _navigateToLinearLayout

    private val _navigateToConstraintLayout by lazy { MutableLiveData<Unit>() }
    val navigateToConstraintLayout: LiveData<Unit> get() = _navigateToConstraintLayout

    private val _navigateToActivityNavigation by lazy { MutableLiveData<Unit>() }
    val navigateToActivityNavigation: LiveData<Unit> get() = _navigateToActivityNavigation

    private val _navigateToBasicFragment by lazy { MutableLiveData<Unit>() }
    val navigateToBasicFragment: LiveData<Unit> get() = _navigateToBasicFragment

    private val _navigateToNavigationComponent by lazy { MutableLiveData<Unit>() }
    val navigateToNavigationComponent: LiveData<Unit> get() = _navigateToNavigationComponent

    private val _navigateToBottomNavigation by lazy { MutableLiveData<Unit>() }
    val navigateToBottomNavigation: LiveData<Unit> get() = _navigateToBottomNavigation

    private val _navigateToArchitecture by lazy { MutableLiveData<Unit>() }
    val navigateToArchitecture: LiveData<Unit> get() = _navigateToArchitecture

    private val _navigateToCallService by lazy { MutableLiveData<Unit>() }
    val navigateToCallService: LiveData<Unit> get() = _navigateToCallService

    private val _navigateToSaveKeyValueData by lazy { MutableLiveData<Unit>() }
    val navigateToSaveKeyValueData: LiveData<Unit> get() = _navigateToSaveKeyValueData

    fun onLinearLayoutClicked() {
        _navigateToLinearLayout.value = Unit
    }

    fun onConstraintLayoutClicked() {
        _navigateToConstraintLayout.value = Unit
    }

    fun onActivityNavigationClicked() {
        _navigateToActivityNavigation.value = Unit
    }

    fun onBasicFragmentClicked() {
        _navigateToBasicFragment.value = Unit
    }

    fun onNavigationComponentClicked() {
        _navigateToNavigationComponent.value = Unit
    }

    fun onBottomNavigationClicked() {
        _navigateToBottomNavigation.value = Unit
    }

    fun onArchitectureClicked() {
        _navigateToArchitecture.value = Unit
    }

    fun onCallServiceClicked() {
        _navigateToCallService.value = Unit
    }

    fun onSaveKeyValueDataClicked() {
        _navigateToSaveKeyValueData.value = Unit
    }
}
