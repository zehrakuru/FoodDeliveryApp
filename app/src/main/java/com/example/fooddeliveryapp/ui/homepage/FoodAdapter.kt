package com.example.fooddeliveryapp.ui.homepage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.R

class FoodAdapter(private val mContext: Context, private val foodsList: List<Foods>) :
    RecyclerView.Adapter<FoodAdapter.CardDesignObjectsHolder>(){

    inner class CardDesignObjectsHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewFood: ImageView
        var txtViewFoodTitle: TextView
        var txtViewFoodDesc: TextView

        init {
            imageViewFood = view.findViewById(R.id.imageViewFood)
            txtViewFoodTitle = view.findViewById(R.id.txtViewFoodTitle)
            txtViewFoodDesc = view.findViewById(R.id.txtViewFoodDesc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.CardDesignObjectsHolder {
        val design =
            LayoutInflater.from(mContext).inflate(R.layout.food_card_design, parent, false)
        return CardDesignObjectsHolder(design)
    }

    override fun getItemCount(): Int {
        return foodsList.size
    }

    override fun onBindViewHolder(holder: FoodAdapter.CardDesignObjectsHolder, position: Int) {
        val food = foodsList[position]

        holder.txtViewFoodTitle.text = food.food_title
        holder.txtViewFoodDesc.text = food.food_desc
        holder.imageViewFood.setImageResource(mContext.resources.getIdentifier(food.food_image_name, "drawable", mContext.packageName))
    }


}