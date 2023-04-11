package com.example.fooddeliveryapp.ui.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        basketViewModel.basketList.observe(viewLifecycleOwner) {
            val adapter = it?.let { it1 -> BasketAdapter(requireContext(), it1) }
            binding.basketAdapter = adapter
        }
        basketViewModel.getMealInBasket()
    }
}