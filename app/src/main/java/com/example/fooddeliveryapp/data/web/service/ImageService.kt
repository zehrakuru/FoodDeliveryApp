package com.example.fooddeliveryapp.data.web.service

import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageService {
    fun showImage(food_name:String, image:ImageView) {
        var IMAGE_URL = "http://kasimadalan.pe.hu/yemekler/resimler/$food_name"

        Picasso.get().load(IMAGE_URL).into(image)

    }
}