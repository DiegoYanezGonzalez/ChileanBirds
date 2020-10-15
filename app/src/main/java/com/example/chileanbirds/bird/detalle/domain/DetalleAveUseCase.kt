package com.example.chileanbirds.bird.detalle.domain

class DetalleAveUseCase(
    private val repository: DetalleAveRepository
) {
    suspend fun excecute(uid : String) = repository.obtenerDetalle(uid )
}