package com.example.chileanbirds.bird.domain

class ObtenerAveUseCase (
    private val repository: AvesRepository
) {

    suspend fun excecute() = repository.obtenerAves()


}