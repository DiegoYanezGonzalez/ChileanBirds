package com.example.chileanbirds.bird.data

import retrofit2.http.GET

interface AvesApi {
    @GET("birds")
    suspend fun getAveApi() : List<AveModel>
}