package com.example.chileanbirds.bird.detalle.data

import retrofit2.http.GET
import retrofit2.http.Path

interface DetalleAveApi {
    @GET("birds/{uid}")
    suspend fun getDetalleAveApi(@Path("uid") uid : String) : DetalleAveModel
}