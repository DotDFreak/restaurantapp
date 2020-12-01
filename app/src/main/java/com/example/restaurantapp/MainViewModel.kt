package com.example.restaurantapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantapp.model.RetrofitPost
import com.example.restaurantapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<RetrofitPost> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response: RetrofitPost=repository.getPost()
            myResponse.value = response
        }
    }
}