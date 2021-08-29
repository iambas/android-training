package com.example.myandroid.di

import com.example.myandroid.network.provideLoggingInterceptor
import com.example.myandroid.network.provideOkHttpClient
import com.example.myandroid.network.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { provideLoggingInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideRetrofit(get()) }
}
