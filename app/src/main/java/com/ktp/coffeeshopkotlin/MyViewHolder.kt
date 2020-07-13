package com.ktp.coffeeshopkotlin

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import javax.inject.Inject


class MyViewHolder(itemView: View, glide: RequestManager) : ViewHolder(itemView) {

    lateinit var glide: RequestManager

    var coffeeText: TextView
    var coffeImage: ImageView

    fun updateWithCoffee(
        mCoffee: Coffee
    ) {
        coffeeText.text = mCoffee.type
        glide
            .load(mCoffee.image)
            .into(coffeImage)
    }


    init {
        this.glide = glide
        coffeeText = itemView.findViewById(R.id.text_recycler_view)
        coffeImage = itemView.findViewById(R.id.image_recycler_view)
    }
}