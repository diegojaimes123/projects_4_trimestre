package com.example.control_estados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.control_estados.ui.theme.Control_EstadosTheme
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.modifier.modifierLocalConsumer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Control_EstadosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        val count: MutableState<Int> = rememberSaveable {
            mutableStateOf(0)
        }
        if (count.value > 0) {
            var showTask by remember {
                mutableStateOf(true)
            }

//            if (showTask) {
//                WellnessTaskItem(
//                    taskName = "Have you taken your 15 minute walk today",
//                    onClose = { showTask = false },
//
//                )
//            }
            Text(
                text = "you have had ${count.value} Glasses.",
            )
        }
        Row {
            Button(
                onClick = { count.value++ },
                Modifier.padding(top = 8.dp),
                enabled = count.value < 10
            ) {
                Text(text = "Add one ")
            }
            Button(
                onClick = { count.value = 0 },
                Modifier.padding(start = 8.dp),
            ) {
                Text(text = "Clear water count ")
            }
        }
    }
}

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    restartCount: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(top = 8.dp),
    ) {
        if (count > 0) {
            Text(text = "you Have a $count glasses")
        }
        Row {
            Button(
                onClick = onIncrement,
                Modifier.padding(top = 8.dp),
                enabled = count < 10
            ) {
                Text(text = "Add one")
            }
            Button(
                onClick = restartCount,
                Modifier.padding(start = 8.dp),
            ) {
                Text(text = "Clear water count ")
            }
        }
    }
}

@Composable
fun StatefulCounter(
    modifier: Modifier = Modifier,
) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StatelessCounter(count, {count ++ },{count = 0} ,modifier)
}
