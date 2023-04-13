package com.example.fooddeliveryapp.ui.basket

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.MainActivity
import com.example.fooddeliveryapp.data.web.model.request.Basket
import com.example.fooddeliveryapp.databinding.BasketCardDesignBinding
import com.example.fooddeliveryapp.ui.homepage.FoodDetailsFragment

class BasketAdapter(private val mContext : Context,
                    private val basketList : List<Basket>,
                    private val basketViewModel : BasketViewModel)
    : RecyclerView.Adapter<BasketAdapter.BasketCardDesignHolder> () {

    inner class BasketCardDesignHolder(binding : BasketCardDesignBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding : BasketCardDesignBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketCardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = BasketCardDesignBinding.inflate(layoutInflater,parent,false)

        return BasketCardDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return basketList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BasketCardDesignHolder, position: Int) {
        val basket = basketList.get(position)
        holder.binding.basketObject = basket
        var foodId = basket.yemekId.toLong()
        var amount = basket.yemekSiparisAdet.toInt()
        var price = basket.yemekFiyat.toInt()

        holder.binding.btnDelete.setOnClickListener {
            basketViewModel.deleteFoodFromBasket(basket.yemekId.toLong())
            MainActivity().setBadgeNumber(MainActivity().getBadgeNumber()-1)
        }
        holder.binding.btnMinusFood.setOnClickListener {
            amount -= 1
            holder.binding.foodAmountBasket.text = amount.toString()
            holder.binding.foodPrice.text = "$amount x $price TL"
            basketViewModel.updateFoodAmountInBasket(foodId, amount)
        }
        holder.binding.btnPlusFood.setOnClickListener {
            amount += 1
            holder.binding.foodAmountBasket.text = amount.toString()
            holder.binding.foodPrice.text = "$amount x $price TL"
            basketViewModel.updateFoodAmountInBasket(foodId, amount)
        }
    }
}