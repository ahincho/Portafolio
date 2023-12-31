package com.ahincho.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun getDogsByBreeds(@Url url: String): Response<DogResponse>
}