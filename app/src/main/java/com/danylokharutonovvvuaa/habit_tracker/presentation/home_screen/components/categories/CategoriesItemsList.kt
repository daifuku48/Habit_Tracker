package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.habits.ItemCardForAddCategory
import com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.habits.ItemCardForAllHabits
import kotlinx.collections.immutable.PersistentList

@Composable
fun CategoriesItemsList(
    categoryList: PersistentList<CategoryDomain>,
    onClickCategory: (CategoryDomain) -> Unit,
    onClickAddCategory: () -> Unit,
    onClickAll: () -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(
            start = 12.dp
        )
    ) {
        item {
            ItemCardForAllHabits(
                onClick = {
                    onClickAll()
                }
            )
        }

        items(categoryList.size) { index ->
            ItemCard(item = categoryList[index],
                count = 2,
                onClickCategory = {
                    onClickCategory(categoryList[index])
                })
        }

        item {
            ItemCardForAddCategory(
                onClick = { onClickAddCategory() }
            )
        }
    }
}
