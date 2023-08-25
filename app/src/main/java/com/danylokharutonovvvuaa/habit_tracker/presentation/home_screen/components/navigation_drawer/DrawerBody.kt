package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen.components.navigation_drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun DrawerBody(
    listItem: List<MenuItem>,
    scope: CoroutineScope,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(){
        items(listItem.size){indexItem->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    scope.launch {
                        onItemClick(listItem[indexItem])
                    }
                }
                .padding(5.dp)
            ){
                Icon(
                    imageVector = listItem[indexItem].icon,
                    contentDescription = "icon"
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = listItem[indexItem].title,
                    modifier = Modifier.weight(1f),
                    style = itemTextStyle,
                    color = Color.Black
                )
            }
        }
    }
}