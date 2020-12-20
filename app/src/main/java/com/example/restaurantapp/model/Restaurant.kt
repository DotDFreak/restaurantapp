package com.example.restaurantapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(                                  //az ettermekhez csinaltam kulon data classt, konnyebnek tunt igy
    val id: Int,                                        // azert parcelize, hogy tudjam argumentumkent atadni safe args pluginnal egyik fragmentbol a masikba
    val name: String,
    val address: String,
    val city: String,
    val state: String,
    val area: String,
    val postal_code: String,
    val country: String,
    val phone: String,
    val lat: Double,
    val lng: Double,
    val price: Int,
    val image_url: String
) : Parcelable