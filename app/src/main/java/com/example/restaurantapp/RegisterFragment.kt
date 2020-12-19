package com.example.restaurantapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.restaurantapp.data.UserData
import com.example.restaurantapp.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class RegisterFragment : Fragment() {

    private lateinit var userView: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        userView = ViewModelProvider(this).get(UserViewModel::class.java)

        view.buttonRegisterFragment.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val userName = editTextUserName.text.toString()
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        if (inputCheck(userName, email, password)){
            val user=UserData(0,userName,email, password)
            userView.addUser(user)
            Toast.makeText(requireContext(),"Successful Registration",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_registerFragment2_to_profile)
        }else{
            Toast.makeText(requireContext(),"Please fill every field",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck ( userName : String, email : String, password: String ) : Boolean {
        return !(TextUtils.isEmpty(userName) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }
}