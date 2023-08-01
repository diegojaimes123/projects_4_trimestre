package com.example.dashboard_v1.comp_login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboard_v1.R
import com.example.dashboard_v1.components.MainPage
import com.example.dashboard_v1.pages.login.LoginScreen
import com.example.dashboard_v1.pages.splash.SplashScreen


enum class PageScreen() {
    Login,
    DashBoard,
    Splash
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiendaAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_boton),
                    )
                }
            }
        }
    )
}

@Composable
fun TiendaApp(
    navController: NavController = rememberNavController()
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = PageScreen.Splash.name
    ) {
        composable(route = PageScreen.Splash.name) {
            SplashScreen(navController)
        }
        composable(route = PageScreen.Login.name) {
            LoginContent(navController)
        }
        composable(route = PageScreen.DashBoard.name) {
            MainPage()
        }
    }
}

@Composable
fun ScaffoldContent(
    // (1)
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = padding.calculateBottomPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            //  (3)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TiendaAppBar(
                canNavigateBack = false,
                navigateUp = {}
            )
        }
    ) { padding ->
        ScaffoldContent(
            padding = padding
        )
        LoginScreen(navController)
    }
}