package com.example.fooddeliveryapp.data.web.service

import com.example.fooddeliveryapp.data.web.model.request.AddMealToBasketRequest
import com.example.fooddeliveryapp.data.web.model.request.Basket
import com.example.fooddeliveryapp.data.web.model.response.DeleteMealFromBasket
import com.example.fooddeliveryapp.data.web.model.request.MealsInBasketRequest
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface BasketDaoInterface {

    @GET("yemekler/sepettekiYemekleriGetir.php")
    fun mealsInBasket() : Call<MealsInBasketRequest>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun addFoodToBasket(@Field("yemek_adi")          yemekAdi : String,
                        @Field("yemek_resim_adi")    yemekResimAdi : String,
                        @Field("yemek_fiyat")        yemekFiyat : Int,
                        @Field("yemek_siparis_adet") yemekSiparisAdet : Int): Call<AddMealToBasketRequest>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun deleteFoodFromBasket(@Field("sepet_yemek_id") sepetYemekId : Int) : Call<DeleteMealFromBasket>
}