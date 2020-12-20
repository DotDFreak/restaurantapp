package com.example.restaurantapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val usrName = MutableLiveData<String>()         //ezt csak azert hoztam letre, hogy a loginbol at tudjam adni a username-et a profilenak,
                                                    //mert bundle-al valamiert nem ment
    fun data(item: String) {
        usrName.value = item
    }
}