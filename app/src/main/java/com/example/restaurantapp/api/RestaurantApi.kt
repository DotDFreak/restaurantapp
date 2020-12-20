package com.example.restaurantapp.api

import com.example.restaurantapp.model.RetrofitPost
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantApi {
    @GET("cities")
    suspend fun getPost(): Response<RetrofitPost>     //get keres a varosok listajara

    @GET("/restaurants?")
    suspend fun getPostRestaurants(
        @Query("city") city : String           //get keres az ettermekre, varos szerint
    ): Response<RetrofitPost>
}