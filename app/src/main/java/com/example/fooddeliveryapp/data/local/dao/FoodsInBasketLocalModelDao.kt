package com.example.fooddeliveryapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.fooddeliveryapp.data.local.model.FoodsInBasketLocalModel

@Dao
interface FoodsInBasketLocalModelDao {
    @Query("SELECT * FROM food_in_basket_table")
    suspend fun allBasketFoods(): List<FoodsInBasketLocalModel>

    @Insert
    suspend fun addFoodsInBasket(foodsInBasket:FoodsInBasketLocalModel)

    @Delete
    suspend fun deleteFoodsInBasket(foodsInBasket:FoodsInBasketLocalModel)

    @Query("DELETE FROM food_in_basket_table WHERE foodId = :foodId")
    suspend fun deleteFoodsInBasketWithID(foodId:Long)
}