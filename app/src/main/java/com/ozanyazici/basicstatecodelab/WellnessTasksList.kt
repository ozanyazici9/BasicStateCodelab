package com.ozanyazici.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            /**
             * Use key param to define unique keys representing the items in a mutable list,
             * instead of using the default key (list position). This prevents unnecessary
             * recompositions.
             */
            /**
             * Bu parametre, genellikle her bir öğenin benzersiz bir özelliğini içeren bir değer alır,
             * böylece her öğe için bir key sağlanır. Bu key değerleri, öğelerin nasıl değiştiğine ve
             * yeniden oluşturulması gerekip gerekmediğine dair Compose'e rehberlik eder.
             */
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}