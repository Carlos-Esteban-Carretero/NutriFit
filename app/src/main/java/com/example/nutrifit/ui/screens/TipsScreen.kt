package com.example.nutrifit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TipsScreen(tips: List<String>) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(top = 16.dp, bottom = 56.dp), // Añadido un padding inferior para evitar la barra de navegación
        verticalArrangement = Arrangement.SpaceBetween // Asegura que los elementos estén distribuidos de forma equitativa
    ) {
        HorizontalPager(
            count = tips.size,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .padding(16.dp)
                ) {
                    Text(
                        text = tips[page],
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        )
                    )
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = Color.Cyan,
            inactiveColor = Color.Gray
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage((pagerState.currentPage - 1).coerceAtLeast(0))
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Previous", tint = Color.White)
            }

            IconButton(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage((pagerState.currentPage + 1).coerceAtMost(tips.lastIndex))
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next", tint = Color.White)
            }
        }
    }
}
val previewTips = listOf(
        "Escoge alimentos integrales: Opta por alimentos integrales en lugar de opciones refinadas para obtener más fibra y nutrientes.",
        "Incorpora grasas saludables: Agrega fuentes de grasas saludables como aguacate, frutos secos y aceite de oliva a tu dieta.",
        "Prueba nuevas recetas: Experimenta con recetas saludables y sabrosas para evitar el aburrimiento en tu dieta.",
        "Haz ejercicio en casa: Realiza rutinas de ejercicio en casa cuando no puedas ir al gimnasio para mantener la consistencia.",
        "Evita las bebidas azucaradas: Reduce el consumo de bebidas azucaradas como refrescos y jugos procesados.",
        "Controla tus antojos: Identifica las causas de tus antojos y busca alternativas saludables para satisfacerlos.",
        "Consume alimentos ricos en calcio: Asegúrate de obtener suficiente calcio a través de alimentos como lácteos, vegetales de hoja verde y pescado.",
        "Mantén un diario de alimentos: Lleva un registro de lo que comes para tomar conciencia de tus hábitos alimenticios y hacer ajustes según sea necesario.",
        "Haz ejercicios de flexibilidad: Practica ejercicios de flexibilidad como yoga o pilates para mejorar la movilidad y reducir el riesgo de lesiones.",
        "Desconéctate de la tecnología: Dedica tiempo a desconectar de dispositivos electrónicos para reducir el estrés y mejorar la calidad del sueño.",
        "Establece metas alcanzables: Define metas realistas y alcanzables tanto en nutrición como en fitness para mantener la motivación a largo plazo.",
        "Consume proteínas vegetales: Incorpora fuentes de proteína vegetal como legumbres, tofu y tempeh en tu dieta para variar tus opciones.",
        "Haz pausas activas: Realiza breves pausas activas durante el día para estirarte y moverte, especialmente si trabajas en un escritorio.",
        "Come despacio y mastica bien: Tómate tu tiempo para comer y mastica cada bocado adecuadamente para facilitar la digestión y evitar comer en exceso.",
        "Limita el consumo de alimentos fritos: Reduce la ingesta de alimentos fritos y opta por métodos de cocción más saludables como al vapor, asado o a la parrilla.",
        "Haz un día de preparación de comidas: Dedica un día a la semana para preparar alimentos saludables en lotes y tener opciones listas para consumir durante la semana.",
        "Incorpora alimentos fermentados: Agrega alimentos fermentados como yogur natural, chucrut o kimchi a tu dieta para mejorar la salud intestinal.",
        "Mantén un equilibrio: Busca un equilibrio entre trabajo, ejercicio y tiempo de ocio para evitar el agotamiento y el estrés.",
        "Disfruta de las comidas en familia: Dedica tiempo a compartir comidas en familia para fomentar una relación saludable con la comida y con tus seres queridos.",
        "Consume grasas omega-3: Incluye fuentes de grasas omega-3 como pescado graso, semillas de lino y nueces para mantener la salud del corazón y del cerebro.",
        "Haz ejercicio en pareja o en grupo: Motívate mutuamente haciendo ejercicio con tu pareja, amigos o un grupo de entrenamiento.",
        "Practica la moderación: Disfruta de tus alimentos favoritos con moderación en lugar de prohibirte completamente ciertos alimentos.",
        "Incorpora alimentos antioxidantes: Consume alimentos ricos en antioxidantes como frutas y vegetales de colores brillantes para proteger tu cuerpo contra el daño de los radicales libres.",
        "Consume suficiente fibra: Aumenta la ingesta de fibra a través de alimentos como cereales integrales, legumbres y frutas para mantener la salud digestiva.",
        "Aprende a leer etiquetas nutricionales: Familiarízate con la lectura de etiquetas nutricionales para tomar decisiones informadas sobre tus alimentos.",
        "Practica la autocompasión: Sé amable contigo mismo y perdona los deslices ocasionales en tu dieta o rutina de ejercicio.",
        "Incorpora alimentos ricos en hierro: Asegúrate de obtener suficiente hierro a través de alimentos como carne magra, espinacas y legumbres para prevenir la anemia.",
        "Prioriza el descanso: Dedica tiempo a descansar y recuperarte adecuadamente después de los entrenamientos intensos para permitir que tu cuerpo se recupere.",
        "Evita comparaciones negativas: Evita compararte con otros en términos de peso o apariencia física y concéntrate en tu propio progreso y bienestar.",
        "Busca actividades al aire libre: Aprovecha el entorno natural para realizar actividades como senderismo, ciclismo o natación al aire libre.",
        "Incorpora alimentos prebióticos: Consume alimentos ricos en prebióticos como ajo, cebolla y plátanos para promover un equilibrio saludable de bacterias intestinales.",
        "Haz ejercicio de alta intensidad: Integra entrenamientos de alta intensidad en tu rutina para mejorar la condición física cardiovascular y quemar calorías.",
        "Consume alimentos ricos en vitamina D: Asegúrate de obtener suficiente vitamina D a través de alimentos como pescado graso, huevos y alimentos fortificados, o mediante la exposición al sol.",
        "Practica la gratitud: Dedica tiempo cada día a reflexionar sobre las cosas por las que estás agradecido, lo cual puede mejorar tu bienestar general.",
        "Mantén una actitud positiva: Cultiva una actitud positiva hacia la alimentación y el ejercicio, centrándote en los beneficios para tu salud en lugar de las restricciones.",
        "Incorpora alimentos ricos en potasio: Consumir alimentos ricos en potasio como plátanos, espinacas y batatas puede ayudar a regular la presión arterial y mantener la salud del corazón.",
        "Busca apoyo profesional: Si tienes dificultades para mantener hábitos saludables, considera buscar la ayuda de un dietista o entrenador personal para obtener orientación y apoyo.",
        "Practica la respiración profunda: Dedica unos minutos al día a practicar la respiración profunda para reducir el estrés y promover la relajación.",
        "Come conscientemente: Presta atención a tus sensaciones de hambre y saciedad mientras comes y evita comer en exceso o distraído.",
        "Incluye alimentos ricos en magnesio: Consume alimentos ricos en magnesio como nueces, semillas y vegetales de hoja verde para apoyar la función muscular y nerviosa.",
        "Evita las dietas extremas: Alejate de las dietas extremadamente restrictivas o de moda que puedan ser perjudiciales para tu salud a largo plazo.",
        "Consume alimentos fermentados: Incorpora alimentos fermentados como kéfir, kombucha y miso para promover un microbioma intestinal saludable.",
        "Practica el autocuidado: Dedica tiempo a cuidar de ti mismo de manera holística, incluyendo el descanso, la relajación y el disfrute de actividades placenteras.",
        "Establece límites de pantalla: Limita el tiempo que pasas frente a pantallas electrónicas para reducir la exposición a la luz azul y mejorar la calidad del sueño.",
        "Mantén una postura adecuada: Consciencia tu postura durante todo el día, especialmente si pasas mucho tiempo sentado, y realiza ejercicios para fortalecer la espalda y el core.",
        "Consume alimentos ricos en vitamina C: Incluye alimentos ricos en vitamina C como cítricos, pimientos y brócoli para apoyar el sistema inmunológico y la salud de la piel.",
        "Practica el tiempo de inactividad: Dedica tiempo a relajarte y desconectar completamente, sin realizar ninguna tarea o actividad, para recargar energías.",
        "Haz un seguimiento de tu progreso: Lleva un registro de tus entrenamientos, tus logros y tus desafíos para mantener la motivación y la responsabilidad.",
        "Consume alimentos ricos en ácidos grasos omega-6: Incorpora fuentes de ácidos grasos omega-6 como semillas de girasol, aceite de cártamo y carne magra para apoyar la salud cardiovascular.",
        "Cultiva la resiliencia: Aprende a adaptarte a los desafíos y contratiempos con una mentalidad de resiliencia, buscando soluciones en lugar de desanimarte."
    )

@Preview(showBackground = true)
@Composable
fun TipsScreenPreview() {
    TipsScreen(tips = previewTips)
}





