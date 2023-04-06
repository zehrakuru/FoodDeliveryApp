package com.example.fooddeliveryapp.ui.offers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.databinding.FragmentOffersBinding

class OffersFragment : Fragment() {

    private lateinit var offersArrayList: ArrayList<Offers>
    private lateinit var adapter: OfferAdapter
    private lateinit var binding: FragmentOffersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOffersBinding.inflate(inflater, container, false)

        binding.rvOffers.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val o1 = Offers(1, "payment", "Do Not Miss This Out!", "Lorem ipsum")
        val o2 = Offers(2, "payment", "Check This!", "Lorem ipsum")
        val o3 = Offers(3, "payment", "Check This Out!", "Lorem ipsum")
        val o4 = Offers(4, "payment", "Last", "Lorem ipsum")

        offersArrayList = ArrayList<Offers>()
        offersArrayList.add(o1)
        offersArrayList.add(o2)
        offersArrayList.add(o3)
        offersArrayList.add(o4)

        adapter = OfferAdapter(requireContext(), offersArrayList)

        binding.rvOffers.adapter = adapter

        return binding.root
    }
}