package com.example.restaurantapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantapp.repository.Repository

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {    //ezt pontosan nem ertettem miert kell megcsinalni, de igy volt a tutorialban
        return MainViewModel(repository) as T                           //ha jol ertettem a viewmodel stabilitasaert jo
    }
}