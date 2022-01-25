package com.tw.mealzapp.ui.meals

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tw.mealzapp.ui.composables.MealCategory
import com.tw.mealzapp.ui.theme.MealzAppTheme


@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel =
        viewModel() // VM will be alive as till activity is alive

    val meals = viewModel.mealsState.value
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            MealCategory(meal = meal)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealsCategoriesScreen()
    }
}

