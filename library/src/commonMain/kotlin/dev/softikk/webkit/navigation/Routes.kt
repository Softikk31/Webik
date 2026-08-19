package dev.softikk.webkit.navigation

import androidx.compose.runtime.Composable

/**
 * [Route] - маршрут.
 * @param [urlPath] url-путь.
 * @param [content] содержащийся composable контент.
 */

data class Route(
    val urlPath: String,
    val content: @Composable () -> Unit
)