package dev.softikk.webkit.components.buttons

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import dev.softikk.webkit.theme.DimensTheme

/**
 * [Button] - кнопка.
 * @param [modifier] модификатор.
 * @param [enabled] включена ли поддеражка нажатий.
 * @param [shape] скругление углов кнопки.
 * @param [containerColor] цвет кнопки.
 * @param [indication] индикация кнопки.
 * @param [interactionSource] интерактивный ресурс.
 * @param [onClick] действия при нажатии.
 * @param [contentPaddings] отступы для контента внутри кнопки.
 * @param [content] контент.
 */

@Composable
fun Button(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = DimensTheme.shapes.smallShape,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    indication: Indication? = null,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
    contentPaddings: PaddingValues = PaddingValues(DimensTheme.paddings.mediumPadding),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.clip(shape).background(containerColor)
            .pointerHoverIcon(PointerIcon.Hand).clickable(
            enabled = enabled,
            interactionSource = interactionSource,
            indication = indication,
            onClick = onClick
        ), contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.padding(contentPaddings)) {
            content()
        }
    }
}