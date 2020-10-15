package com.example.chileanbirds.bird.lista.domain

class ObtenerAveUseCase (
    private val repository: AvesRepository
) {

    suspend fun excecute() = repository.obtenerAves()


}