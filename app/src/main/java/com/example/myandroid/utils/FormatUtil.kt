package com.example.myandroid.utils

import java.text.DecimalFormat

private val decimalFormatter by lazy {
    return@lazy DecimalFormat("#,###,###")
}

/**
 * 1234567 -> 1,234,567
 */
fun Int?.toNumberFormat(): String =
    this?.let {
        decimalFormatter.format(it)
    } ?: ""
