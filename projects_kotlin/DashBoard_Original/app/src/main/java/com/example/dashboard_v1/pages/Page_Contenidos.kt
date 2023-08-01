package com.example.dashboard_v1.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Page_Contenidos() {
    Column() {
        Text(
            text = "Contenidos",
            style = MaterialTheme.typography.bodyMedium
        )
    }

}