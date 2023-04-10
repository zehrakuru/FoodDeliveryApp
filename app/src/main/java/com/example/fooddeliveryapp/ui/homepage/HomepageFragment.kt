package com.example.fooddeliveryapp.ui.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentHomepageBinding
class HomepageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    val mealViewModel: HomepageViewModel by viewModels()

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
    }
}