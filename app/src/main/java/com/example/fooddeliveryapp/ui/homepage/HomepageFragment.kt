package com.example.fooddeliveryapp.ui.homepage

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.web.model.request.AllFoodRequest
import com.example.fooddeliveryapp.databinding.FragmentHomepageBinding
import com.example.fooddeliveryapp.ui.iconFood.FoodLogo
import com.example.fooddeliveryapp.ui.iconFood.FoodLogoAdapter
import java.util.*
import kotlin.collections.ArrayList

class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    val mealViewModel: HomepageViewModel by viewModels()
    private lateinit var foodLogosArrayList: ArrayList<FoodLogo>
    private lateinit var foodLogoAdapter: FoodLogoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mealViewModel.mealsList.observe(viewLifecycleOwner){
            val adapter = FoodAdapter(requireContext(), it)
            binding.mealsAdapter = adapter
        }
        mealViewModel.uploadMeals()

        val fd1 = FoodLogo("Taco", "taco_icon")
        val fd2 = FoodLogo("Pizza", "pizza_icon")
        val fd3 = FoodLogo("Burger", "taco_icon")
        val fd4 = FoodLogo("Kebab", "taco_icon")
        val fd5 = FoodLogo("Ice Cream", "taco_icon")
        val fd6 = FoodLogo("Coffee", "taco_icon")
        val fd7 = FoodLogo("Steak", "taco_icon")
        val fd8 = FoodLogo("Taco", "taco_icon")

        foodLogosArrayList = ArrayList<FoodLogo>()
        foodLogosArrayList.add(fd1)
        foodLogosArrayList.add(fd2)
        foodLogosArrayList.add(fd3)
        foodLogosArrayList.add(fd4)
        foodLogosArrayList.add(fd5)
        foodLogosArrayList.add(fd6)
        foodLogosArrayList.add(fd7)
        foodLogosArrayList.add(fd8)

        foodLogoAdapter = FoodLogoAdapter(requireContext(), foodLogosArrayList)
        binding.rvFoodIcon.adapter = foodLogoAdapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterList(p0)
                return true
            }
        })
    }

    private fun filterList (query : String?) {

        if (query != null) {
            val filteredList = ArrayList<AllFoodRequest.Yemekler>()
            for (i in mealViewModel.mealsList.value!!) {
                if(i.yemekAdi?.lowercase(Locale.ROOT)!!.contains(query))
                    filteredList.add(i)
            }
            if (filteredList.isEmpty()) {
                Toast.makeText(context, "There is no such a food!", Toast.LENGTH_SHORT).show()
            } else {
                binding.mealsAdapter?.setFilteredList(filteredList)
            }
        }

    }
}

