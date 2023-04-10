package com.example.fooddeliveryapp.data.web.model.request


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class AddMealToBasketRequest(
    @SerializedName("message")
    @Expose
    val message: String?,
    @SerializedName("success")
    @Expose
    val success: Int?
)