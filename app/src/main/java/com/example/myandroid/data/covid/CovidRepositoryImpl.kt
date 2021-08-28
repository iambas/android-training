package com.example.myandroid.data.covid

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CovidRepositoryImpl constructor(
    private val covidApi: CovidApi
) : CovidRepository {

    override fun getTimeLineCasesAll(): Flow<List<TimeLineCasesAllResponse>> {
        return flow {
            emit(covidApi.getTimeLineCasesAll())
        }
    }
}
