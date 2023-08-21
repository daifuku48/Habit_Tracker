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
import javax.inject.Inject


@HiltWorker
class DailyUpdateHabitsWorker @AssistedInject constructor(
    @Assisted private val repository: HabitsRepository,
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

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun enqueueDailyUpdateWork() : PeriodicWorkRequest{
            val currentTimeMillis = System.currentTimeMillis()
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = currentTimeMillis
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            val millisUntilMidnight = calendar.timeInMillis + TimeUnit.DAYS.toMillis(1) - currentTimeMillis

            return PeriodicWorkRequest.Builder(
                DailyUpdateHabitsWorker::class.java, 1, TimeUnit.DAYS)
                .setInitialDelay(millisUntilMidnight, TimeUnit.MILLISECONDS)
                .build()
        }
    }
}