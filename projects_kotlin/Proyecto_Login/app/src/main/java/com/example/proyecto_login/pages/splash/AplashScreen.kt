package com.example.proyecto_login.pages.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.proyecto_login.R
import com.example.proyecto_login.components.PageScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    val isVisible = remember { mutableStateOf(true) }

    LaunchedEffect(
        key1 = true,
    ) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(PageScreen.Start.name)
        isVisible.value = false
    }

    Box(modifier = Modifier.fillMaxSize()) {
        val rotationState = remember { Animatable(initialValue = 0f) }

        LaunchedEffect(isVisible.value) {
            if (isVisible.value) {
                rotationState.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = 5000)
                )
            }
        }

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Splash Screen Image",
            modifier = Modifier
                .align(Alignment.Center)
                .size(180.dp, 180.dp)
                .graphicsLayer {
                    rotationZ = if (isVisible.value) {
                        rotationState.value * 360f
                    } else {
                        0f
                    }
                }
        )

        AnimatedVisibility(
            visible = isVisible.value,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.7f))
            )
        }
    }


}

@Composable
fun Splash() {
    Column() {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(180.dp, 180.dp)
        )
        Text(
            text = "Bienvenid@s",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}