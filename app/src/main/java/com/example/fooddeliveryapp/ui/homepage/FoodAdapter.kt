package com.example.fooddeliveryapp.ui.homepage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.data.web.model.request.AllFoodRequest
import com.example.fooddeliveryapp.data.web.service.ImageService
import com.example.fooddeliveryapp.databinding.FoodCardDesignBinding
import androidx.navigation.Navigation

class FoodAdapter(private val mContext: Context, private val foodsList: List<AllFoodRequest.Yemekler>) :
    RecyclerView.Adapter<FoodAdapter.CardDesignObjectsHolder>(){

    inner class CardDesignObjectsHolder(design: FoodCardDesignBinding) : RecyclerView.ViewHolder(design.root) {
        var design:FoodCardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.CardDesignObjectsHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = FoodCardDesignBinding.inflate(layoutInflater, parent, false)
        return CardDesignObjectsHolder(design)
    }

    override fun getItemCount(): Int {
        return foodsList.size
    }

    override fun onBindViewHolder(holder: FoodAdapter.CardDesignObjectsHolder, position: Int) {
        val food = foodsList.get(position)

        holder.design.foodObject = food

        food.yemekResimAdi?.let { ImageService().showImage(it, holder.design.imageViewFood) }

        holder.design.foodCard.setOnClickListener {
            val bundle = Bundle()
            bundle.apply {
                putParcelable("food", AllFoodRequest.Yemekler(food.yemekAdi, food.yemekFiyat, food.yemekId, food.yemekResimAdi))
            }
            food.yemekResimAdi?.let { ImageService().showImage(it, holder.design.imageViewFood) }
            Navigation.findNavController(it).navigate(R.id.foodDetailsTransition, bundle)

        }

    }


}