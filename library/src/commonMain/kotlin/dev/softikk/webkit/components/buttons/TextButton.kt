package dev.softikk.webkit.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import dev.softikk.webkit.components.noIndicationClickable

/**
 * [TextButton] - текстовая кнопка.
 * @param [modifier] модификатор.
 * @param [text] текст.
 * @param [style] стиль текста.
 * @param [color] цвет текста.
 * @param [onClick] действия при нажатии.
 */

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color: Color = MaterialTheme.colorScheme.onSurface,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.noIndicationClickable(
            onClick = onClick
        ).pointerHoverIcon(PointerIcon.Hand)
    ) {
        Text(
            text = text, style = style, color = color
        )
    }
}