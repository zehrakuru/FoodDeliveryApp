package com.example.fooddeliveryapp.data.web.service

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getMealDaoInterface():MealDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(MealDaoInterface::class.java)
        }
    }
}