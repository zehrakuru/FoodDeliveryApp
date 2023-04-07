package com.example.fooddeliveryapp.ui.homepage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddeliveryapp.data.repo.MealsRepository
import com.example.fooddeliveryapp.data.web.model.request.AllFoodRequest

class HomepageViewModel : ViewModel() {
    var mealsList = MutableLiveData<List<AllFoodRequest.Yemekler>>()
    val mrepo = MealsRepository()

    init {
        uploadMeals()
        mealsList = mrepo.mealsRequest()
    }

    fun uploadMeals() {
        mrepo.getAllMeals()
    }

}