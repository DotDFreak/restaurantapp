package com.example.restaurantapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val em: String,
    val userN: String,
    val pass: String
)