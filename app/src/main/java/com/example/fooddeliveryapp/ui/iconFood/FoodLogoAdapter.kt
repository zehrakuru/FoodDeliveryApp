package com.example.fooddeliveryapp.ui.iconFood

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.R

class FoodLogoAdapter(private val mContext: Context, private val foodIconList:List<FoodLogo>) : RecyclerView.Adapter<FoodLogoAdapter.FoodIconDesignHolder>(){

    inner class FoodIconDesignHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewFood: ImageView
        var txtViewFoodTitle : TextView

        init {
            imageViewFood = view.findViewById(R.id.imageViewFood)
            txtViewFoodTitle = view.findViewById(R.id.txtViewFoodTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodIconDesignHolder {
        val design =
            LayoutInflater.from(mContext).inflate(R.layout.food_icon_design, parent, false)
        return FoodIconDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return foodIconList.size
    }

    override fun onBindViewHolder(holder: FoodIconDesignHolder, position: Int) {
        val icon = foodIconList[position]

        holder.txtViewFoodTitle.text = icon.logo_name
        holder.imageViewFood.setImageResource(mContext.resources.getIdentifier(icon.logo_image_view, "drawable", mContext.packageName))
    }
}