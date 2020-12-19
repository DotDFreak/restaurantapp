package com.example.restaurantapp.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDAO: UserDAO, usr: String) {
    val readLoginData: LiveData<List<UserData>> = userDAO.readLoginData()
    val readLoggedData: LiveData<UserData> = userDAO.readLoggedData(usr)
    suspend fun addUser(user: UserData){
        userDAO.addUser(user)
    }
}