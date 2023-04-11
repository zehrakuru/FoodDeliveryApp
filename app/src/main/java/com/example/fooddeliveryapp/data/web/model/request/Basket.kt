package com.example.fooddeliveryapp.data.web.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Basket (@SerializedName("sepet_yemek_id")     @Expose var yemekId:String,
                   @SerializedName("yemek_adi")          @Expose var yemekAdi:String,
                   @SerializedName("yemek_resim_adi")    @Expose var yemekResimAdi:String,
                   @SerializedName("yemek_fiyat")        @Expose var yemekFiyat:String,
                   @SerializedName("yemek_siparis_adet") @Expose var yemekSiparisAdet:String)
    : Serializable {
}