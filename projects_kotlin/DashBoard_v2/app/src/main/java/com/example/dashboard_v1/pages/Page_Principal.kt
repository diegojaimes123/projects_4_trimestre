package com.example.dashboard_v1.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.dashboard_v1.R
import com.example.dashboard_v1.components.AllProducts
import com.example.dashboard_v1.components.notificacionImagen

@Composable
fun Page_Principal() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(3.dp),
//        verticalArrangement = Arrangement.spacedBy(3.dp),
        contentPadding = PaddingValues(horizontal = 2.dp)
    ) {
        items(listaProductosAll) { producto ->
            ProductCardAll(producto = producto)
        }
    }
}

val listaProductosAll = listOf(
    AllProducts.Producto1,
    AllProducts.Producto2,
    AllProducts.Producto3,
    AllProducts.Producto4,
    AllProducts.Producto5,
    AllProducts.Producto6,
    AllProducts.Producto7,
    AllProducts.Producto8,
    AllProducts.Producto9,
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ProductCardAll(producto: AllProducts) {
    val idNotification = 0
    val context: Context = LocalContext.current
    val idChannel: String = stringResource(R.string.canal_Tienda)
    val name: String = stringResource(R.string.canal_Tienda)
    val descripcionTExt: String = stringResource(R.string.canal_Notifi)

    val textShort = "ejemplo de notificacion sencilla con prioridad con omision (default)"
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
        onClick = { showDialog = true },
//        modifier = Modifier
//            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(producto.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    //                    .border(2.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(4.dp))
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
                        style = MaterialTheme.typography.subtitle2
                    )
                }
                Spacer(Modifier.weight(1f))

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
                    Row() {
                        Column {
                            Text(text = producto.name)
                            Text(text = producto.descipcion)
                            Text(text = "$ ${producto.precio}")
                        }
                        Spacer(Modifier.weight(1f))
                        Column {
                            Spacer(Modifier.height(15.dp))
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Car",
                                tint = Color.Black,
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }

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

@Preview
@Composable
fun PrincipalPreview() {
    Page_Principal()
}
