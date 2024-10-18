package com.example.a512lasalleapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.a512lasalleapp.ui.components.ScreenTemplate
import com.example.a512lasalleapp.ui.theme._512LaSalleAppTheme
import com.example.a512lasalleapp.ui.utils.Screens

@Composable
fun GradesScreen(innerPadding: PaddingValues, navController: NavController) {
    ScreenTemplate(innerPadding = innerPadding, header = {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Hola, Edgar",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp)
            )
            Text(
                text = "Tu promedio es de: 9.14",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp)
            )
            Text(
                text = "Semestre: 5to",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp)
            )
            Text(
                text = "Carrera: ISSC",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp)
            )
        }
    }, body = {
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(19.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Materias",
                fontSize = 32.sp,
                color = Color.Black,
            )
            Button(onClick = {navController.navigate(Screens.ClassDetails.route+"/${1}")}) {
                Text(
                    text = "Modelado y Procesamiento de Imágenes:\nPromedio 8.8",
                    textAlign = TextAlign.Center,
                )
            }
            Button(onClick = {navController.navigate(Screens.ClassDetails.route+"/${2}")}) {
                Text(
                    text = "Cristianismo:\nPromedio 8.9",
                    textAlign = TextAlign.Center,
                )
            }
            Button(onClick = {navController.navigate(Screens.ClassDetails.route+"/${3}")}) {
                Text(
                    text = "Administración de Proyectos Tecnológicos:\nPromedio 8.9",
                    textAlign = TextAlign.Center,
                )
            }
            Button(onClick = {navController.navigate(Screens.ClassDetails.route+"/${4}")}) {
                Text(
                    text = "Redes de Area Local:\nPromedio 9.3",
                    textAlign = TextAlign.Center,
                )
            }
            Button(onClick = {navController.navigate(Screens.ClassDetails.route+"/${5}")}) {
                Text(
                    text = "Taller de Desarrollo Móvil Android:\nPromedio 9.4",
                    textAlign = TextAlign.Center,
                )
            }
            Button(onClick = {navController.navigate(Screens.ClassDetails.route+"/${6}")}) {
                Text(
                    text = "Administración Base de Datos:\nPromedio 9",
                    textAlign = TextAlign.Center,
                )
            }
            Button(onClick = {navController.navigate(Screens.ClassDetails.route+"/${7}")},
                modifier = Modifier.padding(bottom = 25.dp)) {
                Text(
                    text = "Modelos Abstractos:\nPromedio 9.5",
                    textAlign = TextAlign.Center,
                )
            }
        }
    })
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GradesScreenPreview() {
    val navController = rememberNavController()
    _512LaSalleAppTheme {
        GradesScreen(innerPadding = PaddingValues(0.dp), navController)
    }
}
