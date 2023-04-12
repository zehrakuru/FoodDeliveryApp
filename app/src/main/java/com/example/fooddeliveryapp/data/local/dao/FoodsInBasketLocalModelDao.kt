package com.example.fooddeliveryapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fooddeliveryapp.data.local.model.FoodsInBasketLocalModel

@Dao
interface FoodsInBasketLocalModelDao {
    @Query("SELECT * FROM food_in_basket_table")
    fun allBasketFoods(): LiveData<List<FoodsInBasketLocalModel>>

    @Insert
    suspend fun addFoodsInBasket(foodsInBasket:FoodsInBasketLocalModel)

    @Delete
    suspend fun deleteFoodsInBasket(foodsInBasket:FoodsInBasketLocalModel)

    @Query("UPDATE food_in_basket_table SET foodAmount = :foodAmount WHERE foodId = :foodId")
    suspend fun updateFoodAmountInBasket(foodId: Long, foodAmount:Int)

    @Query("DELETE FROM food_in_basket_table WHERE foodId = :foodId")
    suspend fun deleteFoodsInBasketWithID(foodId:Long)
}