package com.example.myandroid.di

import com.example.myandroid.data.covid.CovidApi
import com.example.myandroid.data.covid.CovidRepository
import com.example.myandroid.data.covid.CovidRepositoryImpl
import com.example.myandroid.data.shared_preferences.SharedPreferencesRepository
import com.example.myandroid.data.shared_preferences.SharedPreferencesRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {
    single { get<Retrofit>().create(CovidApi::class.java) }
    single<CovidRepository> { CovidRepositoryImpl(get()) }
    single<SharedPreferencesRepository> {
        SharedPreferencesRepositoryImpl(
            prefs = get(),
            encyptedPrefs = get(named(ENCRYPTED_PREFS))
        )
    }
}
