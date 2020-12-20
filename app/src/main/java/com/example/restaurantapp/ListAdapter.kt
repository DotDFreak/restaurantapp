package com.example.restaurantapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurantapp.fragments.ListFragmentDirections
import com.example.restaurantapp.model.Restaurant
import kotlinx.android.synthetic.main.layout_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var restaurantList= emptyList<Restaurant>()                             //adapter a recyclerviewhoz

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = restaurantList[position]
        holder.itemView.nameText.text = currentItem.name
        holder.itemView.addressText.text = currentItem.address
        holder.itemView.priceText.text = currentItem.price.toString()

        holder.itemView.custom_row.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(currentItem)     //ebben adom at a custom row layoutnak az adatokat, kepet is glide-al
            holder.itemView.findNavController().navigate(action)
        }

        val imageUrl = currentItem.image_url
        Glide.with(holder.itemView)
            .load(imageUrl)
            .into(holder.itemView.imageViewList)

    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    fun setData(restaurant: List<Restaurant>){
        this.restaurantList=restaurant
        notifyDataSetChanged()
    }
}