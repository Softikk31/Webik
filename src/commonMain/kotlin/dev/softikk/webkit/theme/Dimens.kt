package dev.softikk.webkit.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Dimens] - размеры.
 * @param [paddings] отступы.
 * @param [shapes] скругления.
 */

data class Dimens(
    val paddings: Paddings = Paddings(),
    val shapes: Shapes = Shapes()
)

/**
 * [Paddings] - размеры.
 * @param [xs2Padding] экстрамаленький 2x.
 * @param [xsPadding] экстрамаленький.
 * @param [smallPadding] маленький.
 * @param [mediumPadding] средний.
 * @param [largePadding] большой.
 * @param [xlPadding] экстрабольшой.
 * @param [xl2Padding] экстрабольшой 2x.
 * @param [xl3Padding] экстрабольшой 3x.
 */

data class Paddings(
    val xs2Padding: Dp = 2.dp,
    val xsPadding: Dp = 4.dp,
    val smallPadding: Dp = 8.dp,
    val mediumPadding: Dp = 16.dp,
    val largePadding: Dp = 32.dp,
    val xlPadding: Dp = 64.dp,
    val xl2Padding: Dp = 128.dp,
    val xl3Padding: Dp = 256.dp,
)

/**
 * [Shapes] - скругления.
 * @param [xsShape] экстрамаленький.
 * @param [smallShape] маленький.
 * @param [mediumShape] средний.
 * @param [largeShape] большой.
 * @param [xlShape] экстрабольшой.
 */

data class Shapes(
    val xsShape: Shape = RoundedCornerShape(4.dp),
    val smallShape: Shape = RoundedCornerShape(8.dp),
    val mediumShape: Shape = RoundedCornerShape(16.dp),
    val largeShape: Shape = RoundedCornerShape(28.dp),
    val xlShape: Shape = RoundedCornerShape(40.dp)
)

val LocalPaddings = staticCompositionLocalOf {
    Paddings()
}

val LocalShapes = staticCompositionLocalOf {
    Shapes()
}

object DimensTheme {
    val paddings
        @Composable
        get() = LocalPaddings.current
    val shapes
        @Composable
        get() = LocalShapes.current
}