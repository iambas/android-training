package com.example.myandroid.data.covid

import retrofit2.http.GET

interface CovidApi {

    @GET("api/Cases/timeline-cases-all")
    suspend fun getTimeLineCasesAll(): List<TimeLineCasesAllResponse>
}
