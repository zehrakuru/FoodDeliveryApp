package com.example.fooddeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_FoodDeliveryApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}