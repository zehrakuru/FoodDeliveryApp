package com.example.fooddeliveryapp.ui.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliveryapp.MainActivity
import com.example.fooddeliveryapp.data.local.database.FoodInBasketRoomDatabase
import com.example.fooddeliveryapp.data.local.model.FoodsInBasketLocalModel
import com.example.fooddeliveryapp.data.repo.BasketRepository
import com.example.fooddeliveryapp.data.web.model.request.Basket
import kotlinx.coroutines.launch

class BasketViewModel : ViewModel() {
    var basketList : LiveData<List<FoodsInBasketLocalModel>>
    lateinit var brepo : BasketRepository

    init {
        val dao = FoodInBasketRoomDatabase.getDatabase(context = MainActivity.context!!).FoodsInBasketLocalModelDao()
        brepo = BasketRepository(dao)
        basketList = brepo.getBasket()
    }

    fun deleteFoodFromBasket(foodId: Long) {
        viewModelScope.launch {
            brepo.deleteMealFromBasket(foodId)
        }
    }

    fun addFoodToBasket(foodName : String, foodImageName : String, foodPrice : Int, addedFoodAmount : Int) {
        viewModelScope.launch {
            brepo.addMealToBasket(foodName, foodImageName, foodPrice, addedFoodAmount)
        }
    }

    fun updateFoodAmountInBasket(foodId: Long, addedFoodAmount: Int) {
        viewModelScope.launch {
            brepo.updateFoodAmountInBasket(foodId, addedFoodAmount)
        }
    }

}