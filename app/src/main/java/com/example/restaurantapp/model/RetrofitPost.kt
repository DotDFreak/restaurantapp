package com.example.restaurantapp.model


data class RetrofitPost(
    val restaurants : List<Restaurant>,
    val cities : Array<String>,
)
