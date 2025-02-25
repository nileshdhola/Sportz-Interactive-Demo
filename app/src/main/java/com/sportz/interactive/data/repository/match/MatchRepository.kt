package com.sportz.interactive.data.repository.match

import com.sportz.interactive.data.model.SportResponse

interface MatchRepository {

    suspend fun fetchMatchDetails(): SportResponse

}