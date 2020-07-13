package com.ktp.coffeeshopkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import javax.inject.Inject


class MyAdapter(
    properties: Array<Coffee>, glide: RequestManager
) :
    RecyclerView.Adapter<MyViewHolder>() {
    // FOR DATA
    private var properties: Array<Coffee>

    lateinit var glide: RequestManager

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context: Context = parent.context
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.view_recycler_sample, parent, false)
        return MyViewHolder(view, glide = glide)
    }

    override fun onBindViewHolder(
        viewHolder: MyViewHolder,
        position: Int
    ) {
        viewHolder.updateWithCoffee(properties.get(position))
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    override fun getItemCount(): Int {
        return properties.size
    }


    // CONSTRUCTOR
    init {
        this.properties = properties
        this.glide = glide
    }
}