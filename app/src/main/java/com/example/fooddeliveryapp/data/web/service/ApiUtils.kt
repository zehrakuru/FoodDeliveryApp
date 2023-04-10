package com.example.fooddeliveryapp.data.web.service

import com.example.fooddeliveryapp.data.web.model.request.Basket

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getMealDaoInterface():MealDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(MealDaoInterface::class.java)
        }

        fun getBasketDaoInterface():BasketDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(BasketDaoInterface::class.java)
        }
    }
}