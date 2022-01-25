package com.tw.mealzapp.model.api


import com.tw.mealzapp.model.response.MealsCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsWebService {
    private lateinit var api: MealsApi

    val baseUrl = "https://www.themealdb.com/api/json/v1/1/"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApi::class.java)
    }

    suspend fun getMeals(): MealsCategoriesResponse { // Removing call as we dnt want to listen as we are using coroutine
        return api.getMeals()
    }

    interface MealsApi {

        @GET("categories.php")
        suspend fun getMeals(): MealsCategoriesResponse // For coroutine
    }
}

