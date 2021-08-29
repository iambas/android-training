package com.example.myandroid.ui.shared_preferences

import androidx.lifecycle.MutableLiveData
import com.example.myandroid.data.shared_preferences.SharedPreferencesRepository
import com.example.myandroid.ui.base.BaseViewModel

class SharedPreferencesViewModel constructor(
    private val sharedPreferencesRepository: SharedPreferencesRepository
) : BaseViewModel() {

    val saveNormal = MutableLiveData<String>()
    val saveWithEncrypted = MutableLiveData<String>()

    init {
        saveNormal.value = sharedPreferencesRepository.saveNormal
        saveWithEncrypted.value = sharedPreferencesRepository.saveWithEncrypted
    }

    fun onSaveNormalClicked() {
        sharedPreferencesRepository.saveNormal = saveNormal.value
    }

    fun onSaveWithEncryptedClicked() {
        sharedPreferencesRepository.saveWithEncrypted = saveWithEncrypted.value
    }
}
