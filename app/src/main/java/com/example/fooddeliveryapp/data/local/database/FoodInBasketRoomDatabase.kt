package com.example.fooddeliveryapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fooddeliveryapp.data.local.dao.FoodsInBasketLocalModelDao
import com.example.fooddeliveryapp.data.local.model.FoodsInBasketLocalModel

@Database(entities = [FoodsInBasketLocalModel::class], version = 1)

public abstract class FoodInBasketRoomDatabase : RoomDatabase() {
    abstract fun FoodsInBasketLocalModelDao() : FoodsInBasketLocalModelDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FoodInBasketRoomDatabase? = null

        fun getDatabase(context: Context): FoodInBasketRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodInBasketRoomDatabase::class.java,
                    "food_in_basket_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}