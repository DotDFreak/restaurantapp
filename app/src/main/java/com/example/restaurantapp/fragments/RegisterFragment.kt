package com.example.restaurantapp.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.restaurantapp.R
import com.example.restaurantapp.data.UserData
import com.example.restaurantapp.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    private lateinit var userView: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        userView = ViewModelProvider(this).get(UserViewModel::class.java)

        view.buttonRegisterFragment.setOnClickListener {
            insertDataToDatabase()                                         // register gombra nyomva, beviszem az adaatokat az adatbazisba
        }

        return view
    }

    private fun insertDataToDatabase() {
        val userName = editTextUserName.text.toString()
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()
        val name = editTextName.text.toString()
        val address = editTextAddress.text.toString()
        val phone = editTextPhone.text.toString()

        if (inputCheck(userName, email, password,name,address,phone)){
            val user=UserData(0,name,address, phone,userName,email, password)                                //ez a fuggveny vezeti be az adatokat az adatbazisba
            userView.addUser(user)
            Toast.makeText(requireContext(),"Successful Registration",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_registerFragment2_to_profile)
        }else{
            Toast.makeText(requireContext(),"Please fill every field",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck ( userName : String, email : String, password: String, name: String, address: String, phone: String ) : Boolean {
        return !(TextUtils.isEmpty(userName) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password) &&
                 TextUtils.isEmpty(name) && TextUtils.isEmpty(address) && TextUtils.isEmpty(phone))            //ezzel leellenorizem, hogy minden adat meg legyen adva
    }
}