package com.example.fooddeliveryapp.ui.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.web.model.request.AllFoodRequest
import com.example.fooddeliveryapp.data.web.service.ApiUtils
import com.example.fooddeliveryapp.databinding.FragmentHomepageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomepageFragment : Fragment() {
    private lateinit var adapter: FoodAdapter
    private lateinit var binding: FragmentHomepageBinding
    val mealViewModel: HomepageViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)
        //binding.rvFoodCard.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        mealViewModel.mealsList.observe(viewLifecycleOwner){
            val adapter = FoodAdapter(requireContext(), it, mealViewModel)
            binding.mealsAdapter = adapter


        }

        /*val p1 = Foods(1, "fishchips", "Hamburger", "Best Seller")
        val p2 = Foods(2, "fishchips", "Pizza", "Lorem ipsum")
        val p3 = Foods(3, "fishchips", "Fish and Chips", "Lorem ipsum")
        val p4 = Foods(4, "fishchips", "Fast Food", "Lorem ipsum")

        foodsArrayList = ArrayList<Foods>()
        foodsArrayList.add(p1)
        foodsArrayList.add(p2)
        foodsArrayList.add(p3)
        foodsArrayList.add(p4)

        adapter = FoodAdapter(requireContext(), foodsArrayList)
        binding.rvFoodCard.adapter = adapter*/
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        mealViewModel.uploadMeals()
    }
}