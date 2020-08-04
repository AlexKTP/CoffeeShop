package com.ktp.coffeeshopkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    private var sugar: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typeOfCoffee = mtypeOfCoffee[args.position]

    }

    private fun configureCheckBox() {
        when (sugar) {
            0 -> {
                checkbox1.isChecked = false; checkbox2.isChecked = false; checkbox3.isChecked =
                    false; checkbox4.isChecked = false
            }
            1 -> {
                checkbox1.isChecked = true; checkbox2.isChecked = false; checkbox3.isChecked =
                    false; checkbox4.isChecked = false
            }
            2 -> {
                checkbox1.isChecked = true; checkbox2.isChecked = true; checkbox3.isChecked =
                    false; checkbox4.isChecked = false
            }
            3 -> {
                checkbox1.isChecked = true; checkbox2.isChecked = true;checkbox3.isChecked =
                    true; checkbox4.isChecked = false
            }
            4 -> {
                checkbox1.isChecked = true; checkbox2.isChecked = true;checkbox3.isChecked =
                    true; checkbox4.isChecked = true
            }
        }
    }

    private fun configureBtn() {
        detail_remove_sugar.setOnClickListener {
            if (sugar > 0) {
                sugar -= 1
                configureCheckBox()
            } else Toast.makeText(activity, "Hum! Black coffee is the best!", Toast.LENGTH_SHORT)
                .show()
        }

        detail_add_sugar.setOnClickListener {
            if (sugar < 4) {
                sugar += 1
                configureCheckBox()
            } else Toast.makeText(activity, "Sugar is not healthy you know?", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.textview_detail.setText(typeOfCoffee.type)
        configureBtn()
        MakingCoffee()
        glide.load(typeOfCoffee.image).into(image_detail)
    }

    private fun MakingCoffee() {
        btn_coffee_maker.setOnClickListener {
            Toast.makeText(activity, "Your Coffee is Ready, Go to Code!", Toast.LENGTH_SHORT).show()
        }
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