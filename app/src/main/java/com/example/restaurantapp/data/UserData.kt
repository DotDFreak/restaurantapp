package com.example.restaurantapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserData(
    @PrimaryKey(autoGenerate = true)            //Felhasznalo adatai
    val id: Int,
    val name : String,
    val address : String,
    val phone : String,
    val username: String,
    val email: String,
    val password: String
)