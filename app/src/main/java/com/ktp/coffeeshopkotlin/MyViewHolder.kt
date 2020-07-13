package com.ktp.coffeeshopkotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class MyViewHolder(itemView: View) : ViewHolder(itemView) {
    var coffeeText: TextView

    fun updateWithCoffee(
        mCoffee: Coffee
    ) {
        coffeeText.text = mCoffee.type
    }


    init {
        coffeeText = itemView.findViewById(R.id.text_recycler_view)
    }
}