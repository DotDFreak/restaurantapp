package com.example.restaurantapp.repository

import com.example.restaurantapp.api.RetrofitInstance
import com.example.restaurantapp.model.RetrofitPost
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<RetrofitPost> {
        return RetrofitInstance.api.getPost()
    }
}