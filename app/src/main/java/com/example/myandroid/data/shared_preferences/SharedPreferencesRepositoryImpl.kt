package com.example.myandroid.data.shared_preferences

import android.content.SharedPreferences

class SharedPreferencesRepositoryImpl constructor(
    private val prefs: SharedPreferences,
    private val encyptedPrefs: SharedPreferences,
) : SharedPreferencesRepository {

    override var saveNormal: String?
        get() = prefs.getString(KEY_SAVE_NORMAL, "")
        set(value) {
            if (value == null) {
                prefs.edit().remove(KEY_SAVE_NORMAL).apply()
            } else {
                prefs.edit().putString(KEY_SAVE_NORMAL, value).apply()
            }
        }

    override var saveWithEncrypted: String?
        get() = prefs.getString(KEY_SAVE_WITH_ENCRYPTED, "")
        set(value) {
            if (value == null) {
                encyptedPrefs.edit().remove(KEY_SAVE_WITH_ENCRYPTED).apply()
            } else {
                encyptedPrefs.edit().putString(KEY_SAVE_WITH_ENCRYPTED, value).apply()
            }
        }

    companion object {
        private const val KEY_SAVE_NORMAL = "KEY_SAVE_NORMAL"
        private const val KEY_SAVE_WITH_ENCRYPTED = "KEY_SAVE_WITH_ENCRYPTED"
    }
}
