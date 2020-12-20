package com.example.restaurantapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.restaurantapp.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_logged_profile.*


class LoggedProfileFragment : Fragment() {
    private lateinit var userView : UserViewModel
    private lateinit var loginView : LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_logged_profile, container, false)
        var usrName = arguments?.getString("message")

        loginView = activity?.run {
            ViewModelProviders.of(this).get(LoginViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        loginView.usrName.observe(viewLifecycleOwner, Observer {
            userView.usr = loginView.usrName.value.toString()
        })

        userView = ViewModelProvider(this).get(UserViewModel::class.java)
        userView.readLoggedData.observe(viewLifecycleOwner, Observer {  it ->
            textViewUserName.text = it.username.toString()
            textViewEmail.text = it.email.toString()
        })

        return view
    }

}