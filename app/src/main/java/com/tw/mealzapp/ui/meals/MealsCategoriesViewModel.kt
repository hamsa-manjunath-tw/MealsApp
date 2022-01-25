package com.tw.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tw.mealzapp.model.MealsRepository
import com.tw.mealzapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    init {

        viewModelScope.launch(Dispatchers.IO) {
            mealsState.value = getMeals()
        }
    }

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().mealCategories


    }
}