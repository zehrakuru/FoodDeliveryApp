package com.example.fooddeliveryapp.ui.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.web.service.ImageService
import com.example.fooddeliveryapp.databinding.FragmentFoodDetailsBinding

class FoodDetailsFragment : Fragment() {

    private lateinit var design: FragmentFoodDetailsBinding
    private val args: FoodDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_food_details, container, false)
        with(design) {
            with(args.food) {
                if (this != null) {
                    foodTitle.text = yemekAdi.toString()
                    priceNum.text = "${yemekFiyat.toString()} TL"
                    if (yemekResimAdi != null) {
                        ImageService().showImage(yemekResimAdi,foodImage)
                    }
                } else {
                    foodTitle.text = "null"
                    priceNum.text = "null"
                }
            }
        }

        var amount = 0

        design.btnMinus.setOnClickListener {
            if (amount > 0) {
                amount -= 1
                design.txtViewFoodAmount.text = amount.toString()
            }
            else {
                Toast.makeText(requireContext(), "There is no food in this cart!", Toast.LENGTH_SHORT).show()
            }
        }

        design.btnPlus.setOnClickListener {
            amount += 1
            design.txtViewFoodAmount.text = amount.toString()
        }

        design
        return design.root
    }
}