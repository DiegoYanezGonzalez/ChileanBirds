package com.example.chileanbirds.bird.detalle.data

import com.example.chileanbirds.bird.detalle.domain.DetalleAveRepository
import com.example.chileanbirds.bird.detalle.domain.model.DetalleAve

class RemoteDetalleAveRepository (
    private val detalleAveApi: DetalleAveApi,
    private val detalleAveMapper: DetalleAveMapper
): DetalleAveRepository {


    override suspend fun obtenerDetalle(uid : String): DetalleAve {
        return detalleAveMapper.mapToEntity(detalleAveApi.getDetalleAveApi(uid))

    }
}