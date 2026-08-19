package dev.softikk.webkit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import dev.softikk.webkit.theme.LocalPaddings
import dev.softikk.webkit.theme.LocalShapes
import dev.softikk.webkit.theme.WebTheme

/**
 * [Website] - главный элемент сайта.
 * @param header заголовок.
 * @param footer нижний колонтитул.
 * @param theme тема, используй класс [dev.softikk.webkit.theme.WebTheme].
 * @param content основной контент сайта.
 * @sample [App]
 */

@Composable
fun Website(
    header: @Composable () -> Unit = {},
    footer: @Composable () -> Unit = {},
    theme: WebTheme,
    content: @Composable () -> Unit,
) {
    theme {
        CompositionLocalProvider(
            LocalPaddings provides theme.dimens.paddings, LocalShapes provides theme.dimens.shapes
        ) {
            Scaffold(
                topBar = header, content = { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            item { content() }
                            item { footer() }
                        }
                    }
                })
        }
    }
}