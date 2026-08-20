package dev.softikk.webkit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/**
 * [noIndicationClickable] - кастомный clickable без пульсации при нажатии.
 * @param [onClick] действия при нажатии.
 */

@Composable
fun Modifier.noIndicationClickable(onClick: () -> Unit = {}) = clickable(
    indication = null,
    interactionSource = remember { MutableInteractionSource() },
    onClick = onClick
)