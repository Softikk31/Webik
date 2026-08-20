package dev.softikk.webkit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

/**
 * [WebNavigation] - навигация.
 * @param [navController] объект типа [NavHostController].
 * @param [startDestination] стартовый маршрут.
 * @param [routes] список маршрутов типа [Route].
 */

@Composable
fun WebNavigation(navController: NavHostController, startDestination: String, routes: List<Route>) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        routes.forEach { route ->
            composable(route = route.urlPath) {
                route.content()
            }
        }
    }
}