package com.sportz.interactive.data.repository.squad

import com.sportz.interactive.data.model.SportResponse

interface SquadRepository {

    suspend fun fetchSquadDetails(): SportResponse
}