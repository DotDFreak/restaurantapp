package com.example.restaurantapp.fragments

import android.os.Bundle
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
import com.example.restaurantapp.ListAdapter
import com.example.restaurantapp.MainViewModel
import com.example.restaurantapp.MainViewModelFactory
import com.example.restaurantapp.R
import com.example.restaurantapp.repository.Repository
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    lateinit var option : Spinner
    private lateinit var viewModel: MainViewModel            //inicializalom a viewmodelleket, spinnert illetve az adaptert a recycleviewhoz
    private lateinit var viewModel2: MainViewModel
    private val myAdapter by lazy {  ListAdapter() }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_list, container, false)

        val repository = Repository()                                                                          //letrehozom a kapcsolatot az apival
        val viewModelFactory = MainViewModelFactory(repository)                                                //ket kulon viewmodel valtozot hasznalok a ket get-hez,
        viewModel=ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)              //lehet meg lehetett volna valositani csak 1-el is
        viewModel2=ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()                             //elso get keres, a varosok listajahoz
        option = view.findViewById(R.id.citySpinner) as Spinner         //inicializalom a spinnert
        val recyclerView = view.recyclerview
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())              //inicializalom a recyclerview-t
        viewModel.myResponse.observe(requireActivity(), Observer { response ->
            if (response.isSuccessful) {
                option.adapter = ArrayAdapter<String>(
                    requireActivity(),                                                      //ha sikeres a lekeres a varosok listajara, berakom oket a spinnerbe
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
                        viewModel2.getPostRestaurants(response.body()!!.cities[position])                           //a kivalasztott varosra a spinnerbol, lekerem az ettermeket
                        viewModel2.myResponse2.observe(requireActivity(), Observer { response ->
                            if (response.isSuccessful) {
                                    myAdapter.setData(response.body()?.restaurants!!)                   //ha sikerult lekerni, atadom a recyclerviewnak
                            } else {
                                Toast.makeText(requireContext(), "Nothing to show", Toast.LENGTH_SHORT).show()
                            }
                        })
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        Toast.makeText(requireContext(), "Nothing selected", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Nothing to select", Toast.LENGTH_SHORT).show()
            }
        })

        return view

    }

}