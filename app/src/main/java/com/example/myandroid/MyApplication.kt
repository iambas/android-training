package com.example.myandroid

import android.app.Application
import com.example.myandroid.di.repositoryModule
import com.example.myandroid.di.networkModule
import com.example.myandroid.di.sharedPreferencesModule
import com.example.myandroid.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(
                sharedPreferencesModule,
                networkModule,
                repositoryModule,
                viewModelModule,
            )
        }
    }
}
