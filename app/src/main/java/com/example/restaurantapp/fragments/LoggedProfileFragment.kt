package com.example.restaurantapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.restaurantapp.LoginViewModel
import com.example.restaurantapp.R
import com.example.restaurantapp.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_logged_profile.*


class LoggedProfileFragment : Fragment() {
    private lateinit var userView : UserViewModel
    private lateinit var loginView : LoginViewModel         //probaltam bundle-al es nem ment, ezert egy kulon viewmodelt hoztam letre ahhoz hogy itt megkapjam
                                                            //a login (profile neve van) fragmenttol a username-et
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_logged_profile, container, false)

        loginView = activity?.run {
            ViewModelProviders.of(this).get(LoginViewModel::class.java)
        } ?: throw Exception("Invalid Activity")                                            //itt kerem le a viewmodelbol a login (profile neve van) fragmentbol a username-et
        loginView.usrName.observe(viewLifecycleOwner, Observer {
            userView.usr = loginView.usrName.value.toString()
        })

        userView = ViewModelProvider(this).get(UserViewModel::class.java)                   //itt pedig atadom a textview-knek a lekert felhasznalo adatait
        userView.readLoggedData.observe(viewLifecycleOwner, Observer {  it ->
            textViewUserNamePR.text = it.username
            textViewEmailPR.text = it.email
            textViewNamePR.text = it.name
            textViewAddressPR.text = it.address
            textViewPhonePR.text = it.phone
        })

        return view
    }

}