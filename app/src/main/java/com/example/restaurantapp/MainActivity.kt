package com.example.restaurantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.restaurantapp.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel=ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response",response.id.toString())
            Log.d("Response",response.name)
            Log.d("Response",response.address)
            Log.d("Response",response.city)
            Log.d("Response",response.state)
            Log.d("Response",response.area)
            Log.d("Response",response.postal_code)
            Log.d("Response",response.country)
            Log.d("Response",response.phone)
            Log.d("Response",response.lat.toString())
            Log.d("Response",response.lng.toString())
            Log.d("Response",response.price.toString())
            Log.d("Response",response.image_url)
        })
    }
}