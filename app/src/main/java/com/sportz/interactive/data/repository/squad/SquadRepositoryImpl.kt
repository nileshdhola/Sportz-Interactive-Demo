package com.sportz.interactive.data.repository.squad

import com.sportz.interactive.data.model.SportResponse
import com.sportz.interactive.data.remote.SquadApiService
import javax.inject.Inject


class SquadRepositoryImpl @Inject constructor(
    private val apiService: SquadApiService
) : SquadRepository {
    override suspend fun fetchSquadDetails(): SportResponse {
        return apiService.getSquadDetails()
    }
}
