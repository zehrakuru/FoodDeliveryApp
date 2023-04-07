package com.example.fooddeliveryapp.data.web.service

import com.example.fooddeliveryapp.data.web.model.request.AllFoodRequest
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface MealDaoInterface {
    @GET("yemekler/tumYemekleriGetir.php")
    fun allMeals(): Call<AllFoodRequest>
}