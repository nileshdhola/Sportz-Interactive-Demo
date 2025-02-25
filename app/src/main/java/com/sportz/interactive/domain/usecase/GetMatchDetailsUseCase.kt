package com.sportz.interactive.domain.usecase

import com.sportz.interactive.data.model.SportResponse
import com.sportz.interactive.data.repository.match.MatchRepository
import javax.inject.Inject

class GetMatchDetailsUseCase @Inject constructor(
    private val repository: MatchRepository
) {
    suspend fun execute(): SportResponse {
        return repository.fetchMatchDetails()
    }
}