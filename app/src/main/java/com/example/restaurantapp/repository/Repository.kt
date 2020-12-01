package com.example.restaurantapp.repository

import com.example.restaurantapp.api.RetrofitInstance
import com.example.restaurantapp.model.RetrofitPost

class Repository {
    suspend fun getPost(): RetrofitPost{
        return RetrofitInstance.api.getPost()
    }
}