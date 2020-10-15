package com.example.chileanbirds.bird.lista.domain.data

import com.example.chileanbirds.bird.lista.domain.model.ImagesAves
import com.example.chileanbirds.bird.lista.domain.model.LinksAves
import com.example.chileanbirds.bird.lista.domain.model.NamesAves

data class AveModel (
    val uid : String? = null,
    val name : NamesAves? = null,
    val images : ImagesAves? = null,
    val links : LinksAves? = null,
    val  sort : Int? = null
)