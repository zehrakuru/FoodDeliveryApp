package com.example.fooddeliveryapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.fooddeliveryapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_FoodDeliveryApp)
        super.onCreate(savedInstanceState)
        context = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        with(binding) {
            NavigationUI.setupWithNavController(bottomNav, navHostFragment.navController)
            //the number should be dynamically
            setBadgeNumber(getBadgeNumber())
            }
    }

   fun setBadgeNumber(number: Int) {
        binding.bottomNav.getOrCreateBadge(R.id.basketFragment).number = number
    }

    fun getBadgeNumber(): Int {
        return binding.bottomNav.getOrCreateBadge(R.id.basketFragment).number
    }
    companion object {
        var context : Context? = null
    }
}