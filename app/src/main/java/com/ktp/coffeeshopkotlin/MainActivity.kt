package com.ktp.coffeeshopkotlin

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

@Inject
lateinit var glide: RequestManager
    lateinit var adapter: MyAdapter
    lateinit var recyclerView: RecyclerView

    private val mTypeOfCoffee = arrayOf(
        Coffee("Espresso", R.drawable.espresso),
        Coffee("Capuccino", R.drawable.capuccino),
        Coffee("Macchiato", R.drawable.macchiato),
        Coffee("Mocha", R.drawable.mocha),
        Coffee("Latte", R.drawable.latte)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        adapter = MyAdapter(mTypeOfCoffee, glide)
        recyclerView = findViewById(R.id.main_recycler_view)
        recyclerView.setAdapter(adapter)
        this.recyclerView.setLayoutManager(LinearLayoutManager(this))


    }

}