package com.example.fooddeliveryapp.data.web.model.request


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class DeleteMealFromBasket(
    @SerializedName("message")
    @Expose
    val message: String?,
    @SerializedName("success")
    @Expose
    val success: Int?
)