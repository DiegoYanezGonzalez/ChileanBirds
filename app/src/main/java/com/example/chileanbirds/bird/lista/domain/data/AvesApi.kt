package com.example.chileanbirds.bird.lista.domain.data

import retrofit2.http.GET

interface AvesApi {
    @GET("birds")
    suspend fun getAveApi() : List<AveModel>
}