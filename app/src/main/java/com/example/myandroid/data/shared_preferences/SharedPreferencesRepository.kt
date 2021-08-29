package com.example.myandroid.data.shared_preferences

interface SharedPreferencesRepository {

    var saveNormal: String?

    var saveWithEncrypted: String?
}
