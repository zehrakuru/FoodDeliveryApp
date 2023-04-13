package com.example.fooddeliveryapp.ui.basket

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
import com.example.fooddeliveryapp.MainActivity
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.web.model.request.Basket
import com.example.fooddeliveryapp.databinding.FragmentBasketBinding

class BasketFragment : Fragment() {

    private lateinit var binding : FragmentBasketBinding
    val basketViewModel: BasketViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basket, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        basketViewModel.basketList.observe(viewLifecycleOwner) { list ->
            val mappedList = list.map {
                Basket(
                    yemekId = it.foodId.toString(),
                    yemekAdi = it.foodName,
                    yemekResimAdi = it.foodImageName,
                    yemekFiyat = it.foodPrice.toString(),
                    yemekSiparisAdet = it.foodAmount
                )
            }
            var totalPrice = 0
            mappedList.forEach {
                totalPrice += calculateTotalPriceInBasket(foodAmount = it.yemekSiparisAdet.toInt(), foodPrice = it.yemekFiyat.toInt())
            }
            binding.totalPriceInBasket.text = "$totalPrice TL"
            val adapter = mappedList?.let { it1 -> BasketAdapter(requireContext(), it1, basketViewModel) }
            binding.basketAdapter = adapter

            binding.btnOrder.setOnClickListener {
                if (totalPrice == 0){
                    Toast.makeText(context, "Your cart is empty!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Your order has been placed!", Toast.LENGTH_SHORT).show()
                    mappedList.forEach {
                        basketViewModel.deleteFoodFromBasket(foodId = it.yemekId.toLong())
                    }
                    MainActivity().setBadgeNumber(0)
                    val navHostFragment = (activity as FragmentActivity).supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
                    val navController = navHostFragment.navController
                    navController.navigate(R.id.homepageFragment)
                }
            }
        }
    }
    fun calculateTotalPriceInBasket(foodAmount: Int, foodPrice: Int): Int {
        var totalPrice = 0
        totalPrice = foodPrice * foodAmount
        return totalPrice
    }
}