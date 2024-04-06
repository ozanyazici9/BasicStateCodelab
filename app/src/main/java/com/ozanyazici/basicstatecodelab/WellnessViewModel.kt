package com.ozanyazici.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    /**
     * Don't expose the mutable list of tasks from outside the ViewModel.
     * Instead define _tasks and tasks. _tasks is internal and mutable inside the ViewModel.
     * tasks is public and read-only.
     */
    /**
     * toMutableStateList(), bir standart Kotlin List'ini veya MutableList'ini Compose'in yeniden çizim ve güncelleme mantığını
     * etkinleştiren ve optimize eden bir MutableStateList'e dönüştürür.
     */
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
