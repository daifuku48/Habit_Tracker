package com.danylokharutonovvvuaa.habit_tracker.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.danylokharutonovvvuaa.habit_tracker.data.worker.DailyUpdateHabitsWorker
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.Navigation
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Habit_TrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Habit_TrackerTheme {
                Navigation()
            }

        }
    }

    fun setWorkers() {
        val workRequest: PeriodicWorkRequest =
            PeriodicWorkRequest.Builder(
                DailyUpdateHabitsWorker::class.java,
                1,
                TimeUnit.DAYS)
                .build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }
}