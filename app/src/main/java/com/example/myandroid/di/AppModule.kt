package com.example.myandroid.di

import com.example.myandroid.data.covid.CovidApi
import com.example.myandroid.data.covid.CovidRepository
import com.example.myandroid.data.covid.CovidRepositoryImpl
import com.example.myandroid.network.provideLoggingInterceptor
import com.example.myandroid.network.provideOkHttpClient
import com.example.myandroid.network.provideRetrofit
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single { get<Retrofit>().create(CovidApi::class.java) }
    single<CovidRepository> { CovidRepositoryImpl(get()) }
}

val networkModule = module {
    factory { provideLoggingInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideRetrofit(get()) }
}
