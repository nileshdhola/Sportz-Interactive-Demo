package com.sportz.interactive.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportz.interactive.data.model.SportResponse
import com.sportz.interactive.domain.usecase.GetMatchDetailsUseCase
import com.sportz.interactive.domain.usecase.GetSquadDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SquadViewModel @Inject constructor(
    private val getMatchDetailsUseCase: GetSquadDetailsUseCase
) : ViewModel() {

    private val _squadDetails = MutableStateFlow<SportResponse?>(null)
    val squadDetails: StateFlow<SportResponse?> = _squadDetails

    init {
        fetchSquadDetails()
    }

    private fun fetchSquadDetails() {
        viewModelScope.launch {
            try {
                _squadDetails.value = getMatchDetailsUseCase.execute()
            } catch (e: Exception) {
                Log.e("squadViewModel", "Error: ${e.message}")
            }
        }
    }
}