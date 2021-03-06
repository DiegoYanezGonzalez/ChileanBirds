package com.example.chileanbirds.bird.detalle.data

import com.example.chileanbirds.bird.detalle.domain.model.DetalleAve

class DetalleAveMapper {
    fun mapToEntity (detalleAveModel: DetalleAveModel): DetalleAve {
        detalleAveModel.apply{
            return DetalleAve(uid, name, map, iucn,habitat,didyouknow,
                size,species,audio,images)
        }
    }
}