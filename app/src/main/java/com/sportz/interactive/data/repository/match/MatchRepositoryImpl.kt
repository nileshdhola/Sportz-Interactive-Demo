package com.sportz.interactive.data.repository.match

import com.sportz.interactive.data.model.SportResponse
import com.sportz.interactive.data.remote.MatchApiService
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val apiService: MatchApiService
) : MatchRepository {
    override suspend fun fetchMatchDetails(): SportResponse {
        return apiService.getMatchDetails()
    }
}
