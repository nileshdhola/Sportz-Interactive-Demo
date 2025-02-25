package com.sportz.interactive.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportz.interactive.data.model.SportResponse
import com.sportz.interactive.domain.usecase.GetMatchDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val getMatchDetailsUseCase: GetMatchDetailsUseCase
) : ViewModel() {

    private val _matchDetails = MutableStateFlow<SportResponse?>(null)
    val matchDetails: StateFlow<SportResponse?> = _matchDetails

    init {
        fetchMatchDetails()
    }

    private fun fetchMatchDetails() {
        viewModelScope.launch {
            try {
                _matchDetails.value = getMatchDetailsUseCase.execute()
            } catch (e: Exception) {
                Log.e("MatchViewModel", "Error: ${e.message}")
            }
        }
    }
}