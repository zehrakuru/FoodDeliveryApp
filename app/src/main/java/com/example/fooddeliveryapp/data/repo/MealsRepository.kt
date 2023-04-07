package com.example.fooddeliveryapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.fooddeliveryapp.data.web.model.request.AllFoodRequest
import com.example.fooddeliveryapp.data.web.service.ApiUtils
import com.example.fooddeliveryapp.data.web.service.MealDaoInterface
import com.example.fooddeliveryapp.ui.homepage.Foods
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository {
    var mealsList: MutableLiveData<List<AllFoodRequest.Yemekler>>
    var fdao : MealDaoInterface

    init {
        mealsList = MutableLiveData()
        fdao = ApiUtils.getMealDaoInterface()
    }

    fun mealsRequest() : MutableLiveData<List<AllFoodRequest.Yemekler>> {
        return mealsList
    }

    fun getAllMeals () {
        fdao.allMeals().enqueue(object: Callback<AllFoodRequest> {
            override fun onResponse(call: Call<AllFoodRequest>, response: Response<AllFoodRequest>) {
                val list = response.body()?.yemekler
                mealsList.value= list as List<AllFoodRequest.Yemekler>?
               /* mealsList.value = list?.map {
                    Foods(

                    )
                }.orEmpty()*/
            }

            override fun onFailure(call: Call<AllFoodRequest>, t: Throwable) {
            }
        })
    }

}