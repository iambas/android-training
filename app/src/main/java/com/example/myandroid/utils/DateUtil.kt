package com.example.myandroid.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "DateUtil"

fun String?.toDateFormat(fromPattern: String, toPattern: String): String? {
    return if (!isNullOrBlank()) {
        try {
            SimpleDateFormat(fromPattern, Locale.getDefault())
                .parse(this)
                ?.let {
                    SimpleDateFormat(toPattern, Locale.getDefault())
                        .format(it)
                }
        } catch (e: Exception) {
            Log.e(TAG, "toDateFormat error: ${e.message}")
            null
        }
    } else {
        null
    }
}
