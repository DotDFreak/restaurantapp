package com.example.restaurantapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        view.textViewName.text = args.currentRestaurant.name
        view.textViewAddress.text = args.currentRestaurant.address
        view.textViewCity.text = args.currentRestaurant.city
        view.textViewState.text = args.currentRestaurant.state
        view.textViewArea.text = args.currentRestaurant.area
        view.textViewPostalCode.text = args.currentRestaurant.postal_code
        view.textViewCountry.text = args.currentRestaurant.country
        view.textViewPhone.text = args.currentRestaurant.phone
        view.textViewLatitude.text = args.currentRestaurant.lat.toString()
        view.textViewLongitude.text = args.currentRestaurant.lng.toString()
        view.textViewPrice.text = args.currentRestaurant.price.toString()


        return view
    }

}