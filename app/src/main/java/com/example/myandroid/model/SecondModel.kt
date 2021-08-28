package com.example.myandroid.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SecondModel(
    val name: String
) : Parcelable
