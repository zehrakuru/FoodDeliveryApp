package com.example.fooddeliveryapp.ui.basket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.data.web.model.request.Basket
import com.example.fooddeliveryapp.databinding.BasketCardDesignBinding

class BasketAdapter(private val mContext : Context, private val basketList : List<Basket>) : RecyclerView.Adapter<BasketAdapter.BasketCardDesignHolder> () {

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

    override fun onBindViewHolder(holder: BasketCardDesignHolder, position: Int) {
        val basket = basketList.get(position)
        holder.binding.basketObject = basket

    }
}