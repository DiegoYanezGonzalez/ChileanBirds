package com.example.chileanbirds.bird.lista.domain.presentation

import com.example.chileanbirds.bird.lista.domain.model.Aves

sealed class AvesUiState  (
    open val result : Aves?  = null
) {
    object LoadingAvesState : AvesUiState()
    data class SuccessAvesState(override  val result : Aves) : AvesUiState(result = result)
    object  EmptyListAvesState : AvesUiState()
    object ErrorServerAvesState  : AvesUiState()
    object NotInternetAvesState : AvesUiState()
}