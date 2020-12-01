package com.example.restaurantapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<UserData>>
    private val repository: UserRepository
    init {
        val userDAO=UserDatabase.getDatabase(application).userDAO()
        repository=UserRepository(userDAO)
        readAllData=repository.readAllData
    }
    fun addUser(user: UserData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}