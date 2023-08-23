package com.danylokharutonovvvuaa.habit_tracker.data.worker

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkerParameters
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Calendar
import java.util.concurrent.TimeUnit

@HiltWorker
class DailyUpdateHabitsWorker @AssistedInject constructor(
    private val repository: HabitsRepository,
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        withContext(Dispatchers.IO){
            try {
                val habits = repository.getAllHabits()
                habits.map {
                    it.isFinishedToday = false
                }
                for (item in habits){
                    repository.updateHabit(item)
                }
            } catch(_: Exception){
                return@withContext Result.failure()
            }
        }
        return Result.success()
    }
}