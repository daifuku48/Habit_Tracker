package com.danylokharutonovvvuaa.habit_tracker.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.danylokharutonovvvuaa.habit_tracker.domain.repository.HabitsRepository
import javax.inject.Inject

class CustomWorkerFactory @Inject constructor(
    private val repository: HabitsRepository,

) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker = DailyUpdateHabitsWorker(repository, appContext, workerParameters)
}