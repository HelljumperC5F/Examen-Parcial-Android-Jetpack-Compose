package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a512lasalleapp.R
import com.example.a512lasalleapp.ui.theme.BlueDark

@Composable
fun PagosScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        PagoView("Enero", true)
        PagoView("Febrero", true)
        PagoView("Marzo", true)
        PagoView("Abril", false)
    }
}

@Composable
fun PagoView(mes: String, pagado: Boolean) {
    Row(
        modifier = Modifier
            .background(BlueDark)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        var image = R.drawable.crossed
        if (pagado) {image = R.drawable.check}
        Image(
            painter = painterResource(image),
            contentDescription = "Imagen Pago Completado",
            modifier = Modifier
                .size(100.dp),
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
        ) {
            Text(
                text = mes,
                color = Color.White,
                fontSize = 32.sp
            )
            if (pagado) {
                Text(
                    text = "Estado: Pagado",
                    color = Color.White,
                )
            } else {
                Text(
                    text = "Estado: Sin pagar",
                    color = Color.White,
                )
            }
        }
    }
}