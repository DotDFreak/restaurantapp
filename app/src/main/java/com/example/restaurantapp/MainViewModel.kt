package com.example.restaurantapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantapp.model.Restaurant
import com.example.restaurantapp.model.RetrofitPost
import com.example.restaurantapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<RetrofitPost>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<RetrofitPost>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response: Response<RetrofitPost> =repository.getPost()
            myResponse.value = response
        }
    }

    fun getPostRestaurants(city: String) {
        viewModelScope.launch {
            val response = repository.getPostRestaurants(city)
            myResponse2.value=response
        }
    }
}