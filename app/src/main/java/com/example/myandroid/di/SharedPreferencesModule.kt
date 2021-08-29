package com.example.myandroid.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val ENCRYPTED_PREFS = "encrypted_prefs"

private const val MY_SHARED_PREFERENCES = "my_shared_preferences"
private const val MY_ENCRPTED_SHARED_PREFERENCES = "my_encrpted_shared_preferences"

val sharedPreferencesModule = module {
    single { initSharedPreferences(get(), MY_SHARED_PREFERENCES) }
    single(named(ENCRYPTED_PREFS)) {
        initEncryptedSharedPreferences(get(), MY_ENCRPTED_SHARED_PREFERENCES)
    }
}

private fun initSharedPreferences(context: Context, fileName: String): SharedPreferences {
    return context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
}

private fun initEncryptedSharedPreferences(context: Context, fileName: String): SharedPreferences {
    return EncryptedSharedPreferences.create(
        fileName,
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}
