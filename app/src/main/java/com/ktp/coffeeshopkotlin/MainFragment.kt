package com.ktp.coffeeshopkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment(), View.OnClickListener {

    var navController: NavController? = null

    @Inject
    lateinit var mTypeOfCoffee: Array<Coffee>


    @Inject
    lateinit var glide: RequestManager


    lateinit var adapter: MyAdapter
    lateinit var recyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        navController = Navigation.findNavController(view)
        adapter = MyAdapter(mTypeOfCoffee, glide)
        recyclerView = view.findViewById(R.id.main_recycler_view)
        recyclerView.setAdapter(adapter)
        this.recyclerView.setLayoutManager(LinearLayoutManager(activity))
        adapter.onItemClick = { position ->
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(position)
            view.findNavController().navigate(action)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}