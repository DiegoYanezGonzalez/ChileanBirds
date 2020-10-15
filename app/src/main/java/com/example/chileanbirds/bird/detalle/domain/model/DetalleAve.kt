package com.example.chileanbirds.bird.detalle.domain.model

import com.example.chileanbirds.bird.lista.domain.model.NamesAves

data class DetalleAve (
    val uid : String? = null,
    val name : NamesAves? = null,
    val map : MapAve? = null,
    val iucn : IucnAve? = null,
    val habitat : String? = null,
    val didyouknow : String? = null,
    val size : String? = null,
    val species : String? = null,
    val audio : Audio? = null,
    val images : ImagesDetalle? = null
)