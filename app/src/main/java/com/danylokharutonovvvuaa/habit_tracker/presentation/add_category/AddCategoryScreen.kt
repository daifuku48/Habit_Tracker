package com.danylokharutonovvvuaa.habit_tracker.presentation.add_category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_category.components.ColumnText
import com.danylokharutonovvvuaa.habit_tracker.presentation.add_category.components.SpaceBetween
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple40


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCategoryScreen(navController: NavController, vm: AddCategoryViewModel){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            modifier = Modifier
                .width(300.dp) // Adjust the width as needed
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .clickable(onClick = {
                        navController.navigate("home_screen")
                    })
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_clear_24),
                    contentDescription = "close button"
                )
            }

            SpaceBetween()

            ColumnText("New Category")

            SpaceBetween()

            var categoryText by remember { mutableStateOf(TextFieldValue("")) }
            TextField(
                value = categoryText,
                onValueChange = { newText ->
                    categoryText =  newText
                },
                modifier = Modifier
                    .border(
                        BorderStroke(width = 2.dp, color = Purple40),
                        shape = RoundedCornerShape(50)
                    )
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_clear_24),
                        contentDescription = "clearIconCategory",
                        modifier = Modifier.clickable(
                            onClick = {
                                categoryText = TextFieldValue("")
                            }
                        )
                    )
                }
            )

            SpaceBetween()

            Button(
                onClick = {
                    if (categoryText.text != ""){
                        vm.setCategory(categoryText.text)
                        vm.addCategory()
                        navController.navigate("home_screen")
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Save")
            }
        }
    }
}


