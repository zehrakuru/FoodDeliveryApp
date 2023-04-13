package com.example.fooddeliveryapp.ui.homepage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.fooddeliveryapp.MainActivity
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.web.service.ImageService
import com.example.fooddeliveryapp.databinding.FragmentFoodDetailsBinding
import com.example.fooddeliveryapp.ui.basket.BasketViewModel

class FoodDetailsFragment : Fragment() {

    private lateinit var design: FragmentFoodDetailsBinding
    private val args: FoodDetailsFragmentArgs by navArgs()
    val basketViewModel : BasketViewModel by viewModels()
    var amount = 0

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_food_details, container, false)
        design.foodDetailsFragment = this
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

        design.btnMinus.setOnClickListener {
            if (amount > 0) {
                amount -= 1
                design.txtViewFoodAmount.text = amount.toString()
            }
            else {
                Toast.makeText(requireContext(), "There is no food selected!", Toast.LENGTH_SHORT).show()
            }
        }

        design.btnPlus.setOnClickListener {
            amount += 1
            design.txtViewFoodAmount.text = amount.toString()
        }
        return design.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        design.btnAddToCart.setOnClickListener {
            buttonAddToCart(args.food?.yemekAdi, args.food?.yemekResimAdi, args.food?.yemekFiyat, design.txtViewFoodAmount.text.toString())
            MainActivity().setBadgeNumber(MainActivity().getBadgeNumber()+1)
            val navHostFragment = (activity as FragmentActivity).supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.homepageFragment)
        }
    }

    fun buttonAddToCart(yemek_adi : String?, yemek_resim_adi : String?, yemek_fiyat : String?, yemek_siparis_adet : String) {
        if (yemek_adi != null && yemek_resim_adi != null && yemek_fiyat != null) {
            basketViewModel.addFoodToBasket(
                yemek_adi,
                yemek_resim_adi,
                yemek_fiyat.toString().toInt(),
                yemek_siparis_adet.toInt()
            )
            Toast.makeText(requireContext(), "Your food is added to cart!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Something is null", Toast.LENGTH_LONG).show()
        }
    }
}