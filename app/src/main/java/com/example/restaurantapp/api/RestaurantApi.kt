package com.example.restaurantapp.api

import com.example.restaurantapp.model.RetrofitPost
import retrofit2.http.GET

interface RestaurantApi {
    @GET("restaurants?name=a/")
    suspend fun getPost(): RetrofitPost
}