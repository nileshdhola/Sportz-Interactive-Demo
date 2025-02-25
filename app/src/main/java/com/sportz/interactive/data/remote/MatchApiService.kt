package com.sportz.interactive.data.remote

import com.sportz.interactive.data.model.SportResponse
import retrofit2.http.GET

interface MatchApiService {

    @GET("nzin01312019187360.json")
    suspend fun getMatchDetails(): SportResponse

}