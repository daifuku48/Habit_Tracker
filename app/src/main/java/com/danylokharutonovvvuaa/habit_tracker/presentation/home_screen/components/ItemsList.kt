package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoriesItem

@Composable
fun ItemsList(){

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(
            start = 12.dp
        )
    ){

        val count = 2
        val list = listOf(
            CategoriesItem(0, "Penis",  "Desription", 1),
            CategoriesItem(1, "Pen",  "Desription", 2)
        )
        items(count){index->
            ItemCard(item = list[index])
        }
        item {
            ItemCardForAddCategory()
        }
    }
}

@Preview
@Composable
fun Preview(){
    ItemsList()
}
