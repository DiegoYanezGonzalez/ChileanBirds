package com.example.chileanbirds.bird.data

import com.example.chileanbirds.bird.domain.AvesRepository
import com.example.chileanbirds.bird.domain.model.Aves

class RemoteAvesRepository (
    private val avesApi: AvesApi,
    private val aveMapper: AveMapper
) : AvesRepository {
    override suspend fun obtenerAves(): Aves {
        val aves = avesApi.getAveApi()

        val listaTrasformada =
            aves.map { aveMapper.mapToEntity(it) } ?: emptyList()

        return Aves(listaTrasformada)
    }
}