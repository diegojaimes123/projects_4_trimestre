package com.example.dashboard_v1.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.example.dashboard_v1.R
import com.example.dashboard_v1.components.ListLacteos
import com.example.dashboard_v1.components.notificacionImagen

@Composable
fun Page_Lacteos() {
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
//        verticalArrangement = Arrangement.spacedBy(3.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
        ){
            items(listaProductosLacteos) { producto ->
                ProductCard(producto = producto)
            }
        }
    }
}

val listaProductosLacteos = listOf(
    ListLacteos.Lacteo01,
    ListLacteos.Lacteo02,
    ListLacteos.Lacteo03,
)

@Composable
private fun ProductCard(producto: ListLacteos) {
    val idNotification = 0
    val context: Context = LocalContext.current
    val idChannel: String = stringResource(R.string.canal_Tienda)
    val name: String = stringResource(R.string.canal_Tienda)
    val descripcionTExt: String = stringResource(R.string.canal_Notifi)

    val textShort = "ejemplo de notificacion sencilla con prioridad con omision (default) "
    val textLong: String =
        "Saludos, esta es un aprueba de notificacion. Debe Aparecer " + "un icono a la derecha y el texto puede tener un alongitud de 200 caracteres " + "el tamano de la notificacion puede colapsar y/o expandirse " + "Gracias y hasta pronto "
    val iconBig = BitmapFactory.decodeResource(
        context.resources, R.drawable.logo_sena
    )
    val imageBig = BitmapFactory.decodeResource(
        context.resources, producto.image
    )
    var showDialog by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(producto.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Column {
                    Text(
                        text = producto.name,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = producto.descipcion,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = "$ ${producto.precio}",
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Car",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
    if (showDialog) {
        Dialog(
            onDismissRequest = { showDialog = false },
        ) {
            Card(
                backgroundColor = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                    //                    .background(Color.White)
                ) {
                    Image(
                        painter = painterResource(producto.image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = producto.name)
                    Text(text = producto.descipcion)
                    Text(text = "$ ${producto.precio}")
                    Button(
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = {
                            showDialog = false
                            notificacionImagen(
                                context,
                                idChannel,
                                idNotification,
                                "El Usuario vio el producto ${producto.name}",
                                textLong,
                                iconBig,
                                imageBig
                            )
                        }
                    ) {
                        Text(text = "Cerrar")
                    }
                }
            }
        }
    }
}


