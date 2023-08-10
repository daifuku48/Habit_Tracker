package com.danylokharutonovvvuaa.habit_tracker.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danylokharutonovvvuaa.habit_tracker.R
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoriesItem
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Purple80
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(//navController: NavController, vm: HomeScreenViewModel
 ) {
    AppBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    val coroutineScope = rememberCoroutineScope()
    //layout
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.good_habits)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {

                        }
                    }) {
                        Icon(painter = painterResource(
                            id = R.drawable.baseline_dehaze_24),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        coroutineScope.launch {

                        }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                    coroutineScope.launch {

                    }
                },

            ) {
                Icon(painter = painterResource(
                    id = R.drawable.baseline_add_24),
                    contentDescription = null
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { paddingValues ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)) {
                CategoriesText()
                ItemsList(paddingValues)
            }
        }
    )
}

@Composable
fun CategoriesText(){
    Text(
        text = stringResource(R.string.categories),
        fontSize = 30.sp,
        color = Color.Black,
        fontFamily = FontFamily(Font(R.font.notosans_bold)),
        modifier = Modifier.padding(
            top = 10.dp,
            start = 20.dp,
            bottom = 10.dp
        )
    )
}

@Composable
fun ItemsList(paddingValues: PaddingValues){

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
        items(count){count->
            ItemCard(item = list[count])
        }
    }
}


@Composable
fun ItemCard(item: CategoriesItem) {
    Box(
        modifier = Modifier
        .padding(8.dp)
        .size(120.dp)
        .background(
            color = Purple80,
            shape = RoundedCornerShape(15.dp)
    ),
    ) {
        Column(modifier = Modifier.align(Alignment.CenterStart)) {
            Text(text = item.countOfActivities.toString() + "habits")
            Text(
                text = item.category,
                fontFamily = FontFamily(Font(R.font.notosans_bold)),
                fontSize = 24.sp,
                modifier = Modifier.padding()
            )
        }
    }
}

@Composable
fun CheckingHabits(vm: HomeScreenViewModel){

}

@Preview
@Composable
fun Preview(){
    AppBar()
}