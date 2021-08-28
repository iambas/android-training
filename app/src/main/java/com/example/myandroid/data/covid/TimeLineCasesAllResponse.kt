package com.example.myandroid.data.covid

import com.example.myandroid.utils.toDateFormat
import com.example.myandroid.utils.toNumberFormat
import com.google.gson.annotations.SerializedName

data class TimeLineCasesAllResponse(
    @SerializedName("txn_date") val txnDate: String? = null,
    @SerializedName("new_case") val newCase: Int? = null,
    @SerializedName("total_case") val totalCase: Int? = null,
    @SerializedName("update_date") val updateDate: String? = null,
) {

    val txnDateFormat: String
        get() = txnDate.toDateFormat(
            fromPattern = "yyyy-MM-dd",
            toPattern = "dd/MM/yyyy"
        ) ?: ""

    val newCaseFormat: String
        get() = newCase.toNumberFormat()

    val totalCaseFormat: String
        get() = totalCase.toNumberFormat()
}
