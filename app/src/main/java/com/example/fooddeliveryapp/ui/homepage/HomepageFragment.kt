package com.example.fooddeliveryapp.ui.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentHomepageBinding
import com.example.fooddeliveryapp.databinding.FragmentOffersBinding
import com.example.fooddeliveryapp.ui.offers.OfferAdapter
import com.example.fooddeliveryapp.ui.offers.Offers

private lateinit var foodsArrayList: ArrayList<Foods>
private lateinit var adapter: FoodAdapter
private lateinit var binding: FragmentHomepageBinding
class HomepageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)

        binding.rvFoodCard.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val p1 = Foods(1, "fishchips", "Hamburger", "Best Seller")
        val p2 = Foods(2, "fishchips", "Pizza", "Lorem ipsum")
        val p3 = Foods(3, "fishchips", "Fish and Chips", "Lorem ipsum")
        val p4 = Foods(4, "fishchips", "Fast Food", "Lorem ipsum")

        foodsArrayList = ArrayList<Foods>()
        foodsArrayList.add(p1)
        foodsArrayList.add(p2)
        foodsArrayList.add(p3)
        foodsArrayList.add(p4)

        adapter = FoodAdapter(requireContext(), foodsArrayList)
        binding.rvFoodCard.adapter = adapter



        return binding.root
    }
}