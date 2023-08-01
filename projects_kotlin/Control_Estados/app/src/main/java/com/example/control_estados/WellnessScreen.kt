package com.example.control_estados

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        WellnesTaskList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task)},
            onCheckedTask = {task , checked -> wellnessViewModel.changeTaskChecked(task, checked)}
        )
    }
}

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task # $i",
    initialChecked  = false)
}
