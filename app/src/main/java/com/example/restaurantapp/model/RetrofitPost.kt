package com.example.restaurantapp.model


data class RetrofitPost(
    val total_entries: Int,
    val per_page: Int,
    val current_page: Int,
    val restaurants : List<Restaurant>,
    val count: Int,
    val cities : List<String>
)
