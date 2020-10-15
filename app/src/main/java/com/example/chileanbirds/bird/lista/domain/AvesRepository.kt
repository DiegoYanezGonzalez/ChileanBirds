package com.example.chileanbirds.bird.lista.domain

import com.example.chileanbirds.bird.lista.domain.model.Aves

interface AvesRepository {
    suspend fun obtenerAves() : Aves
}