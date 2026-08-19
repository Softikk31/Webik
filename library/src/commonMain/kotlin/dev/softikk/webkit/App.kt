package dev.softikk.webkit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import dev.softikk.webkit.components.buttons.TextButton
import dev.softikk.webkit.components.layout.BasicFooter
import dev.softikk.webkit.components.layout.BasicHeader
import dev.softikk.webkit.navigation.Route
import dev.softikk.webkit.navigation.WebNavigation
import dev.softikk.webkit.theme.DimensTheme
import dev.softikk.webkit.theme.WebTheme

@Composable
fun App() {
    val colorScheme = lightColorScheme(
        primary = Color.Blue,
        background = Color.White,
        surface = Color.White,
        onSurface = Color.Black
    )
    val typography = Typography(
        bodyMedium = TextStyle(fontSize = 16.sp),
        bodyLarge = TextStyle(fontSize = 20.sp),
        headlineSmall = TextStyle(fontSize = 24.sp),
        headlineMedium = TextStyle(fontSize = 32.sp)
    )

    val navController = rememberNavController()

    Website(
        header = {
        BasicHeader(
            navigation = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(DimensTheme.paddings.mediumPadding)
                ) {
                    TextButton(text = "home", color = MaterialTheme.colorScheme.primary) {
                        navController.navigate("home")
                    }
                    TextButton(text = "info", color = MaterialTheme.colorScheme.primary) {
                        navController.navigate("info")
                    }
                }
            })
    }, footer = {
        BasicFooter {
            Text("FOOTER", color = MaterialTheme.colorScheme.primary)
        }
    }, theme = WebTheme(
        colorScheme = colorScheme, typography = typography
    )
    ) {
        WebNavigation(
            navController = navController, startDestination = "home", routes = listOf(
                Route(
                    urlPath = "home", content = {
                        Column {
                            repeat(100) {
                                Text(
                                    if (Mobile.isMobile()) "MOBILE" else "THIS IS HOME SCREEN",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }), Route(
                    urlPath = "info", content = {
                        Column {
                            repeat(100) {
                                Text(
                                    "THIS IS INFO SCREEN",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    })
            )
        )
    }
}