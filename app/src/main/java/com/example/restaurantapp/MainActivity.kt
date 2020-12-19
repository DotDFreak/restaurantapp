package com.example.restaurantapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.bottomNavHost)
        val appBarConfiguration= AppBarConfiguration(
            setOf(
                R.id.listFragment,
                R.id.profile,
                R.id.favourites
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

        /*val checkedItemId = bottomNavigationView.selectedItemId
        if(checkedItemId==2) {
            val fragLogin = Profile()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragLogin).commit()
        }*/
    }

   /*override fun passData(usrName: String) {
        val bundle = Bundle()
        bundle.putString("message", usrName)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragProf = LoggedProfileFragment()
        fragProf.arguments = bundle

        transaction.replace(R.id.fragment_container, fragProf)
        transaction.commit()
    }*/


}