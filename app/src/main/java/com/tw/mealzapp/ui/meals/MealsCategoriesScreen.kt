package com.tw.mealzapp.ui.meals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.tw.mealzapp.model.response.MealResponse
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

@Composable
fun MealCategory(meal: MealResponse) {
    Card(
        shape = RoundedCornerShape(8.dp), elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            Image(
                painter = rememberImagePainter(meal.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(text = meal.name, style = MaterialTheme.typography.h6)

            }
        }
    }

}