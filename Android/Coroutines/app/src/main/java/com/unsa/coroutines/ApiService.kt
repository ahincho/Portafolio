package com.unsa.coroutines

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/10229233666327556/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superheroName: String): Response<SuperHero>
}
