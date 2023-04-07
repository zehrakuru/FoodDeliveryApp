package com.example.fooddeliveryapp.data.web.model.request

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class AllFoodRequest(
    @SerializedName("success")
    @Expose
    val success: Int?,
    @SerializedName("yemekler")
    @Expose
    val yemekler: List<Yemekler?>?
) {
    data class Yemekler(
        @SerializedName("yemek_adi")
        @Expose
        val yemekAdi: String?,
        @SerializedName("yemek_fiyat")
        @Expose
        val yemekFiyat: String?,
        @SerializedName("yemek_id")
        @Expose
        val yemekId: String?,
        @SerializedName("yemek_resim_adi")
        @Expose
        val yemekResimAdi: String?
    )
}