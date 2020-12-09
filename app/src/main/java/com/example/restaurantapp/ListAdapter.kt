package com.example.restaurantapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.model.Restaurant
import kotlinx.android.synthetic.main.layout_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var restaurantList= emptyList<Restaurant>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.nameText.text = restaurantList[position].name
        holder.itemView.addressText.text = restaurantList[position].address
        holder.itemView.priceText.text = restaurantList[position].price.toString()
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    fun setData(restaurant: List<Restaurant>){
        this.restaurantList=restaurant
        notifyDataSetChanged()
    }
}