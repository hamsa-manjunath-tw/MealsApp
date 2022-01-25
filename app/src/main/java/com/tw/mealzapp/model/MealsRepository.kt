package com.tw.mealzapp.model

import com.tw.mealzapp.model.api.MealsWebService
import com.tw.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}