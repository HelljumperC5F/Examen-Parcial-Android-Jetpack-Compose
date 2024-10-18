package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.a512lasalleapp.ui.theme.BlueDark
import com.example.a512lasalleapp.ui.theme.White
import com.example.a512lasalleapp.ui.utils.newsList
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

@Composable
fun ClassDetails(classId: Int, innerPadding: PaddingValues){
    var calificaciones = mutableListOf<Double>()
    var nombreMateria = ""
    when (classId) {
        1 -> {
            calificaciones = mutableListOf(8.3, 9.2, 9.0)
            nombreMateria = "Modelado y Procesamiento de Imágenes"
        }
        2 -> {
            calificaciones = mutableListOf(8.6, 8.4, 9.7)
            nombreMateria = "Cristianismo"
        }
        3 -> {
            calificaciones = mutableListOf(9.5, 8.8, 8.5)
            nombreMateria = "Administración de Proyectos Tecnológicos"
        }
        4 -> {
            calificaciones = mutableListOf(9.3, 9.2, 9.6)
            nombreMateria = "Redes de Area Local"
        }
        5 -> {
            calificaciones = mutableListOf(9.3, 9.1, 10.0)
            nombreMateria = "Taller de Desarrollo Móvil Android"
        }
        6 -> {
            calificaciones = mutableListOf(8.4, 9.1, 9.5)
            nombreMateria = "Administración Base de Datos"
        }
        7 -> {
            calificaciones = mutableListOf(9.8, 8.8, 10.0)
            nombreMateria = "Modelos Abstractos"
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.padding(innerPadding)
                .background(BlueDark, shape = RoundedCornerShape(10.dp))
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = nombreMateria,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = White,
                modifier = Modifier.padding(top = 15.dp)
            )
            Text(
                text = "Primer Parcial: ${calificaciones[0]}",
                fontSize = 15.sp,
                color = White,
                modifier = Modifier.padding(top = 15.dp)
            )
            Text(
                text = "Segundo Parcial: ${calificaciones[1]}",
                fontSize = 15.sp,
                color = White,
                modifier = Modifier.padding(top = 15.dp)
            )
            Text(
                text = "Tercer Parcial: ${calificaciones[2]}",
                fontSize = 15.sp,
                color = White,
                modifier = Modifier.padding(top = 15.dp)
            )
        }
    }
}
