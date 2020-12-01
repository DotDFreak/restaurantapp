package com.example.restaurantapp.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDAO: UserDAO) {
    val readAllData: LiveData<List<UserData>> = userDAO.readAllData()
    suspend fun addUser(user: UserData){
        userDAO.addUser(user)
    }
}