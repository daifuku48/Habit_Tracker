package com.danylokharutonovvvuaa.habit_tracker.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DailyUpdateHabitsWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    @Inject
    lateinit var repository : HabitsRepository

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