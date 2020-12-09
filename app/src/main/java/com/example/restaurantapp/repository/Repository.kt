package com.example.restaurantapp.repository

import androidx.lifecycle.LiveData
import com.example.restaurantapp.api.RetrofitInstance
import com.example.restaurantapp.model.Restaurant
import com.example.restaurantapp.model.RetrofitPost
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<RetrofitPost> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPostRestaurants(city:String) : Response<RetrofitPost> {
        return RetrofitInstance.api.getPostRestaurants(city)
    }
}