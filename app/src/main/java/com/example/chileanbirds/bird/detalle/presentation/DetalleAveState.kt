package com.example.chileanbirds.bird.detalle.presentation

import com.example.chileanbirds.bird.detalle.domain.model.DetalleAve

sealed class DetalleAveState(
    open val result: DetalleAve? = null
) {

    object  LoadingDetalleState : DetalleAveState()
    data class SuccessAvesState (override  val result: DetalleAve): DetalleAveState(result = result)
    object  EmptyListAvesState : DetalleAveState()
    object  ErrorServerAvesState  : DetalleAveState()
    object  NotInternetAvesState : DetalleAveState()

}