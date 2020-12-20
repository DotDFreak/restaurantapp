package com.example.restaurantapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.restaurantapp.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class Profile : Fragment() {
    private lateinit var userView : UserViewModel
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.buttonRegister.setOnClickListener{
            findNavController().navigate(R.id.action_profile_to_registerFragment2)
        }
        view.buttonLogin.setOnClickListener{
            login()
        }

        return view
    }

    private fun login() {

        val usrName = editTextLoginUserName.text.toString()
        val pWord = editTextLoginPassword.text.toString()

        if(loginCheck(usrName,pWord)){
            userView = ViewModelProvider(this).get(UserViewModel::class.java)
            userView.readLoginData.observe(viewLifecycleOwner, Observer { user->
                for( i in user){
                    if (i.password.toString()==pWord && i.username.toString()==usrName ){
                        Toast.makeText(requireContext(),"Login successful", Toast.LENGTH_LONG).show()
                        viewModel = activity?.run {
                            ViewModelProviders.of(this).get(LoginViewModel::class.java)
                        } ?: throw Exception("Invalid Activity")
                        viewModel.usrName.value = usrName
                        findNavController().navigate(R.id.action_profile_to_loggedProfileFragment)
                    }
                }
            })
        }else{
            Toast.makeText(requireContext(),"Please fill all the fields",Toast.LENGTH_LONG).show()
        }
    }

    private fun loginCheck ( userName : String, password: String ) : Boolean {
        return !(TextUtils.isEmpty(userName) && TextUtils.isEmpty(password))
    }

}