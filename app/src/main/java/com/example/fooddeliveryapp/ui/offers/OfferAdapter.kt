package com.example.fooddeliveryapp.ui.offers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.R
import com.google.android.material.animation.AnimationUtils

class OfferAdapter(private val mContext: Context, private val offersList: List<Offers>) :
RecyclerView.Adapter<OfferAdapter.CardDesignObjectsHolder>(){

    inner class CardDesignObjectsHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageViewOffer: ImageView
        var txtViewTitle: TextView
        var txtViewDesc: TextView
        var cardView: CardView

        init {
            imageViewOffer = view.findViewById(R.id.imageViewOffer)
            txtViewTitle = view.findViewById(R.id.txtViewTitle)
            txtViewDesc = view.findViewById(R.id.txtViewDesc)
            cardView = view.findViewById(R.id.cardView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignObjectsHolder {
        val design =
            LayoutInflater.from(mContext).inflate(R.layout.offers_card_preview, parent, false)
        return CardDesignObjectsHolder(design)
    }

    override fun getItemCount(): Int {
        return offersList.size
    }

    override fun onBindViewHolder(holder: CardDesignObjectsHolder, position: Int) {
        val offer = offersList[position]

        holder.txtViewTitle.text = offer.offer_title
        holder.txtViewDesc.text = offer.offer_desc
        holder.imageViewOffer.setImageResource(mContext.resources.getIdentifier(offer.offer_image_name, "drawable", mContext.packageName))
        holder.cardView.startAnimation(android.view.animation.AnimationUtils.loadAnimation(mContext, R.anim.anim1))

    }


}