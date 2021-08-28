package com.example.myandroid.data.covid

import kotlinx.coroutines.flow.Flow

interface CovidRepository {

    fun getTimeLineCasesAll(): Flow<List<TimeLineCasesAllResponse>>

}
