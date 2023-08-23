package com.danylokharutonovvvuaa.habit_tracker.presentation.activities

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.danylokharutonovvvuaa.habit_tracker.data.worker.DailyUpdateHabitsWorker
import com.danylokharutonovvvuaa.habit_tracker.presentation.base.Navigation
import com.danylokharutonovvvuaa.habit_tracker.presentation.ui.theme.Habit_TrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setWorkers()
        setContent {
            Habit_TrackerTheme {
                Navigation()
            }
        }
    }

    private fun setWorkers() {
        val currentTimeMillis = System.currentTimeMillis()
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTimeMillis
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        val millisUntilMidnight = calendar.timeInMillis + TimeUnit.DAYS.toMillis(1) - currentTimeMillis

        val workerRequest =  PeriodicWorkRequest
            .Builder(
                DailyUpdateHabitsWorker::class.java, 1,
                TimeUnit.DAYS
            )
            .setInitialDelay(
                millisUntilMidnight,
                TimeUnit.MILLISECONDS
            )
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "updateHabitSchedule",
            ExistingPeriodicWorkPolicy.KEEP,
            workerRequest
        )
    }
}