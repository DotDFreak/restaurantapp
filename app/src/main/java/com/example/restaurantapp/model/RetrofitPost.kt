package com.example.restaurantapp.model


data class RetrofitPost(
    val restaurants : List<Restaurant>,         //ez a valasz data class, vagy egy restaurant listat dolgozok fel az apibol, vagy egy varos listat
    val cities : Array<String>
)
