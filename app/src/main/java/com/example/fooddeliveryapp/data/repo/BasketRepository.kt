package com.example.fooddeliveryapp.data.repo

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fooddeliveryapp.data.local.dao.FoodsInBasketLocalModelDao
import com.example.fooddeliveryapp.data.local.model.FoodsInBasketLocalModel
import com.example.fooddeliveryapp.data.web.model.request.AddMealToBasketRequest
import com.example.fooddeliveryapp.data.web.model.request.Basket
import com.example.fooddeliveryapp.data.web.model.request.MealsInBasketRequest
import com.example.fooddeliveryapp.data.web.model.response.DeleteMealFromBasket
import com.example.fooddeliveryapp.data.web.service.ApiUtils
import com.example.fooddeliveryapp.data.web.service.BasketDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class BasketRepository(val foodsInBasketLocalModelDao: FoodsInBasketLocalModelDao) {

    fun getBasket(): LiveData<List<FoodsInBasketLocalModel>> {
        return foodsInBasketLocalModelDao.allBasketFoods()
    }

    suspend fun addMealToBasket(
        yemekAdi: String,
        yemekResimAdi: String,
        yemekFiyat: Int,
        yemekSiparisAdet: Int
    ) {
        /*bdao.addFoodToBasket(yemekAdi, yemekResimAdi, yemekFiyat, yemekSiparisAdet)
            .enqueue(object : Callback<AddMealToBasketRequest> {
                override fun onResponse(
                    call: Call<AddMealToBasketRequest>,
                    response: Response<AddMealToBasketRequest>
                ) {
                    val success = response.body()?.success
                    val message = response.body()?.message
                }

                override fun onFailure(call: Call<AddMealToBasketRequest>, t: Throwable) {
                }
            })*/
        val foodInBasket = FoodsInBasketLocalModel(
            foodName = yemekAdi,
            foodImageName = yemekResimAdi,
            foodPrice = yemekFiyat,
            foodAmount = yemekSiparisAdet.toString()
        )
        foodsInBasketLocalModelDao.addFoodsInBasket(foodInBasket)
    }

    suspend fun deleteMealFromBasket(basketYemekId: Long) {
        /*bdao.deleteFoodFromBasket(basketYemekId).enqueue(object : Callback<DeleteMealFromBasket> {
            override fun onResponse(
                call: Call<DeleteMealFromBasket>,
                response: Response<DeleteMealFromBasket>
            ) {
            }
            override fun onFailure(call: Call<DeleteMealFromBasket>, t: Throwable) {
            }
        })*/
        foodsInBasketLocalModelDao.deleteFoodsInBasketWithID(basketYemekId)
    }

    suspend fun updateFoodAmountInBasket(basketYemekId: Long, yemekSiparisAdet: Int) {
        foodsInBasketLocalModelDao.updateFoodAmountInBasket(basketYemekId, yemekSiparisAdet)
    }

}