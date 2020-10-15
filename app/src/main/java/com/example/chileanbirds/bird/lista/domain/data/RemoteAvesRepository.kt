package com.example.chileanbirds.bird.lista.domain.data

import com.example.chileanbirds.bird.lista.domain.AvesRepository
import com.example.chileanbirds.bird.lista.domain.model.Aves

class RemoteAvesRepository (
    private val avesApi: AvesApi,
    private val aveMapper: AveMapper
) : AvesRepository {
    override suspend fun obtenerAves(): Aves {
        val aves = avesApi.getAveApi()

        val listaTrasformada =
            aves.map { aveMapper.mapToEntity(it) }

        return Aves(listaTrasformada)
    }
}