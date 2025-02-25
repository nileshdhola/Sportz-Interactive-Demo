package com.sportz.interactive.domain.usecase

import com.sportz.interactive.data.model.SportResponse
import com.sportz.interactive.data.repository.squad.SquadRepository
import javax.inject.Inject

class GetSquadDetailsUseCase @Inject constructor(
    private val repository: SquadRepository
) {
    suspend fun execute(): SportResponse {
        return repository.fetchSquadDetails()
    }
}