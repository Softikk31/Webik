package dev.softikk.webkit.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

/**
 * [WebTheme] - тема. [invoke] используется для использования темы.
 * @param [colorScheme] цветавая схема.
 * @param [dimens] размеры.
 * @param [typography] типографика.
 */

class WebTheme(
    val colorScheme: ColorScheme,
    val dimens: Dimens = Dimens(),
    val typography: Typography = Typography()
) {
    @Composable
    internal operator fun invoke(content: @Composable () -> Unit) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}