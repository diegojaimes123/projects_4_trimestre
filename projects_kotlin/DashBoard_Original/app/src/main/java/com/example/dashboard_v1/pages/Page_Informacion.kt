package com.example.dashboard_v1.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dashboard_v1.R
import com.example.dashboard_v1.components.CreateChannelNotification
import com.example.dashboard_v1.components.noticacionExtensa
import com.example.dashboard_v1.components.notificacionImagen
import com.example.dashboard_v1.components.notificacionProgramada
import com.example.dashboard_v1.components.notificacionSencilla


@Composable
fun Page_Informacion() {

    val idNotification = 0
    val context: Context = LocalContext.current
    val idChannel: String = stringResource(R.string.canal_Tienda)
    val name: String = stringResource(R.string.canal_Tienda)
    val descripcionTExt: String = stringResource(R.string.canal_Notifi)

    val textShort = "ejemplo de notificacion sencilla con prioridad con omision (default) "
    val textLong: String =
        "Saludos, esta es un aprueba de notificacion. Debe Aparecer " + "un icono a la derecha y el texto puede tener un alongitud de 200 caracteres " + "el tamano de la notificacion puede colapsar y/o expandirse " + "Gracias y hasta pronto "
    val iconBig = BitmapFactory.decodeResource(
        context.resources, R.drawable.ic_launcher_foreground
    )
    val imageBig = BitmapFactory.decodeResource(
        context.resources, R.drawable.bg_tienda_cba
    )

//    funcion de creaccion proopia como corrutina

    LaunchedEffect(Unit) {
        CreateChannelNotification(
            idChannel, context, name, descripcionTExt
        )
    }

    val modifier = Modifier
        .padding(18.dp)
        .fillMaxWidth()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(18.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Informacion de Notificaciones",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 100.dp)
        )

        Button(
            onClick = {
                notificacionSencilla(
                    context,
                    idChannel,
                    idNotification,
                    "NOtificacion Sencilla",
                    textShort
                )
            },
            modifier = modifier
        ) {
            Text(text = "Notificaciones Sencilla")
        }


        Button(
            onClick = {
                noticacionExtensa(
                    context,
                    idChannel,
                    idNotification,
                    "NOtificacion Extensa",
                    textLong,
                    iconBig
                )
            },
            modifier = modifier
        ) {
            Text(text = "Notificaciones Extensa")
        }


        Button(
            onClick = {
                notificacionImagen(
                    context,
                    idChannel,
                    idNotification,
                    "NOtificacion Con Imagen",
                    textLong,
                    iconBig,
                    imageBig
                )
            },
            modifier = modifier
        ) {
            Text(text = "Notificaciones con  Imagen ")
        }


        Button(
            onClick = {
                notificacionProgramada(
                    context
                )
            },
            modifier = modifier
        ) {
            Text(text = "Notificaciones Programada")
        }
    }
}
