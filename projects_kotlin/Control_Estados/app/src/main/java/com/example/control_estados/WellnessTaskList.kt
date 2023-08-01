package com.example.control_estados

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(
        i, "Task # $i",
        initialChecked = false
        )
}

@Composable
fun WellnesTaskList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
    onCheckedTask: (WellnessTask, Boolean) -> Unit

    ) {
    LazyColumn(modifier = modifier ){

        items (
            items = list,
            key = {task -> task.id}
                ) {task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) },
                modifier = modifier
            )
        }
    }
}