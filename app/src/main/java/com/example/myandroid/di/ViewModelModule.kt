package com.example.myandroid.di

import com.example.myandroid.ui.MainViewModel
import com.example.myandroid.ui.covid.CovidViewModel
import com.example.myandroid.ui.architecture.ArchitectureViewModel
import com.example.myandroid.ui.shared_preferences.SharedPreferencesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { ArchitectureViewModel() }
    viewModel { CovidViewModel(get()) }
    viewModel { SharedPreferencesViewModel(get()) }
}
