package com.example.whatthefilm

import retrofit2.Call

import retrofit2.http.GET

interface ApiInterface {
    @GET("/3/movie/popular?api_key=73a66a60dd5d4398f55b9b7a12111288")
    fun getListMovie(): Call<Response>
}
