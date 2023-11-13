package com.sandbox.modularsandbox.data

import retrofit2.http.GET

interface JokeApi {
    @GET("jokes/random")
    suspend fun fetchJoke(): JokeDto
}