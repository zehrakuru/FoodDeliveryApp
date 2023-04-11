package com.example.fooddeliveryapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_in_basket_table")
data class FoodsInBasketLocalModel(
    @ColumnInfo("foodName") val foodName : String,
    @ColumnInfo("foodImageName") val foodImageName : String,
    @ColumnInfo("foodPrice") val foodPrice : Int,
    @ColumnInfo("foodAmount") val foodAmount : String
){
    @PrimaryKey(autoGenerate = true)
    var foodId : Long = 0
}
