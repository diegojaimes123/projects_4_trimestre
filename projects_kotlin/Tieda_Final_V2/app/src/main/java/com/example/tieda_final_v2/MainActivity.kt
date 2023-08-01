package com.example.tieda_final_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dashboard_v1.comp_login.TiendaApp
import com.example.dashboard_v1.ui.theme.DashBoard_v1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashBoard_v1Theme {
                TiendaApp()
            }
        }
    }
}