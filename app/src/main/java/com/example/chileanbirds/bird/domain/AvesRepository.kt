package com.example.chileanbirds.bird.domain

import com.example.chileanbirds.bird.domain.model.Aves

interface AvesRepository {
    suspend fun obtenerAves() : Aves
}