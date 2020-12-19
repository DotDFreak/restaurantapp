package com.example.restaurantapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val usrName = MutableLiveData<String>()

    fun data(item: String) {
        usrName.value = item
    }
}