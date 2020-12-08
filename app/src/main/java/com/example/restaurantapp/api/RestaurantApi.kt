package com.example.restaurantapp.api

import com.example.restaurantapp.model.RetrofitPost
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApi {
    @GET("/api/cities")
    suspend fun getPost(): Response<RetrofitPost>
}