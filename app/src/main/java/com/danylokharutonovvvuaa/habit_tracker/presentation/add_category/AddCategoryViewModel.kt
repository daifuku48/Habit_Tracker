package com.danylokharutonovvvuaa.habit_tracker.presentation.add_category

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danylokharutonovvvuaa.habit_tracker.domain.model.CategoryDomain
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.AddCategoryUseCase
import com.danylokharutonovvvuaa.habit_tracker.domain.use_cases.GetAllHabitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddCategoryViewModel @Inject constructor(
    private val addCategoryUseCase: AddCategoryUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val category: MutableState<CategoryDomain?> = mutableStateOf(null)

    fun setCategory(text: String){
        category.value = CategoryDomain(
            category = text,
            countOfActivities = 0
        )
    }

    fun addCategory(){
        viewModelScope.launch {
            addCategoryUseCase.execute(
                categoryDomain = category.value as CategoryDomain
            )
        }
    }
}