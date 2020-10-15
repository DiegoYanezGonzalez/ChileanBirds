package com.example.chileanbirds.bird.detalle.domain

import com.example.chileanbirds.bird.detalle.domain.model.DetalleAve

interface DetalleAveRepository {
    suspend fun obtenerDetalle(uid : String): DetalleAve
}