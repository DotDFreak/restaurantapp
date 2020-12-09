package com.example.restaurantapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantapp.repository.Repository
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    lateinit var option : Spinner
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModel2: MainViewModel
    private val myAdapter by lazy {  ListAdapter() }
    var x: Int = 0
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_list, container, false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel=ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel2=ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        option = view.findViewById(R.id.citySpinner) as Spinner
        val recyclerView = view.recyclerview
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.myResponse.observe(requireActivity(), Observer { response ->
            if (response.isSuccessful) {
                option.adapter = ArrayAdapter<String>(
                    requireActivity(),
                    android.R.layout.simple_spinner_dropdown_item,
                    response.body()!!.cities
                )
                option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        var loc: String = response.body()!!.cities[position]
                        viewModel2.getPostRestaurants(loc)
                        viewModel2.myResponse2.observe(requireActivity(), Observer { response ->
                            if (response.isSuccessful) {
                                    myAdapter.setData(response.body()?.restaurants!!)
                            } else {
                                Toast.makeText(requireContext(), "Nothing to show", Toast.LENGTH_SHORT).show()
                            }
                        })
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        Log.d("Nothing selected", x.toString())
                    }
                }
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })

        return view

    }

}