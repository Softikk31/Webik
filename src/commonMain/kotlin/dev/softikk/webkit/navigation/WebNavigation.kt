package dev.softikk.webkit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/**
 * [WebNavigation] - навигация.
 * @param [navController] объект типа [NavHostController].
 * @param [onNavHostReady] suspend-лямбда для связи с навигационным трафиком браузера.
 * @param [startDestination] стартовый маршрут.
 * @param [routes] список маршрутов типа [Route].
 *
 * Пример использования [WebNavigation]:
 *
 * **App.kt**:
 * ```kotlin
 * @Composable
 * fun App(suspend (NavController) -> Unit) {
 *     val navController = rememberNavController()
 *
 *     WebNavigation(
 *         navController = navController,
 *         onNavHostReady = onNavHostReady,
 *         startDestination = "home",
 *         routes = listOf(
 *             Route(
 *                 urlPath = "home",
 *                 content = { ... }
 *             )
 *         )
 *     )
 * }
 * ```
 *
 * **main.kt**:
 * ```kotlin
 * @OptIn(ExperimentalComposeUiApi::class)
 * @ExperimentalBrowserHistoryApi
 * fun main() {
 *     val body = document.body ?: return
 *     ComposeViewport(body) {
 *         App(
 *             onNavHostReady = { it.bindToBrowserNavigation() }
 *         )
 *     }
 * }
 * ```
 */

@Composable
fun WebNavigation(
    navController: NavHostController,
    onNavHostReady: (suspend (NavController) -> Unit)? = null,
    startDestination: String,
    routes: List<Route>
) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        routes.forEach { route ->
            composable(route = route.urlPath) {
                route.content()
            }
        }
    }
    onNavHostReady?.let {
        LaunchedEffect(navController) {
            onNavHostReady(navController)
        }
    }
}