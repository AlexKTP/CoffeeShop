package com.ktp.coffeeshopkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import javax.inject.Inject


class DetailFragment : DaggerFragment() {

    val args: DetailFragmentArgs by navArgs()

    @Inject
    lateinit var glide: RequestManager

    @Inject
    lateinit var mtypeOfCoffee: Array<Coffee>

    lateinit var typeOfCoffee: Coffee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typeOfCoffee = mtypeOfCoffee[args.position]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.text_detail.setText(typeOfCoffee.type)
        glide.load(typeOfCoffee.image).into(image_detail)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_detail, container, false)

        return view
    }

}