package com.example.dashboard_v1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun BottomMenu(
    navController: NavHostController,
    menu_items_bar: List<Items_Bar>
){
    androidx.compose.material.BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
    ) {
        BottomNavigation(
            modifier = Modifier
                .padding(
                0.dp,
                0.dp,
                60.dp,
                0.dp
            )
                .background(Color.Blue)
        ) {
            val currentRouteBar = Current_Route(navController = navController)
            menu_items_bar.forEach { item ->
                BottomNavigationItem(
                    selected = currentRouteBar == item.ruta,
                    onClick = { navController.navigate(item.ruta) },
                    icon = {
                        androidx.compose.material.Icon(
                            modifier = Modifier.size(23.dp),
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(
                        item.title,
                    ) }
                )
            }
        }
    }
}
@Composable
fun Fab(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
){
    androidx.compose.material.FloatingActionButton(
        onClick = {
            scope.launch {
                scaffoldState.snackbarHostState
                    .showSnackbar(
                        "Proximamente disponible!",
                        actionLabel = "Aceptar",
                        duration = SnackbarDuration.Indefinite
                    )
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    ) {
        androidx.compose.material.Icon(
            imageVector = Icons.Filled.List,
            contentDescription = "Recompensas"
        )

    }
}