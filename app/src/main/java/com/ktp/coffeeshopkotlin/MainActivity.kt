package com.ktp.coffeeshopkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: MyAdapter
    lateinit var viewHolder: MyViewHolder
    lateinit var recyclerView: RecyclerView
    var listAdapter = null


    private val mTypeOfCoffee = arrayOf(
        Coffee("Espresso"),
        Coffee("Capuccino"),
        Coffee("Macchiato"),
        Coffee("Mocha"),
        Coffee("Latte")
    )

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        adapter = MyAdapter(mTypeOfCoffee)
        recyclerView = findViewById(R.id.main_recycler_view)
        // 3.3 - Attach the adapter to the recyclerview to populate items
        // 3.3 - Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter)
        // 3.4 - Set layout manager to position the items
        // 3.4 - Set layout manager to position the items
        this.recyclerView.setLayoutManager(LinearLayoutManager(this))


    }

}