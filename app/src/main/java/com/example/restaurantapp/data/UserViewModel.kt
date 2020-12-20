package com.example.restaurantapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch


@OptIn(InternalCoroutinesApi::class)
class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readLoginData: LiveData<List<UserData>>                             //viewmodel, amiben az adatbazis valtozoit,
    val readLoggedData: LiveData<UserData>                                  //fuggvenyeit deklaralom, livedata hasznalatahoz
    var usr : String = "Teszt"
    private val repository: UserRepository
    init {
        val userDAO=UserDatabase.getDatabase(application).userDAO()
        repository=UserRepository(userDAO,usr)
        readLoginData=repository.readLoginData
        readLoggedData=repository.readLoggedData
    }
    fun addUser(user: UserData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}