package dev.softikk.webkit.utils

import kotlinx.browser.window
import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.js

@OptIn(ExperimentalWasmJsInterop::class)
internal fun isTouchDevice(): Boolean = js("\"ontouchstart\" in window")

@OptIn(ExperimentalWasmJsInterop::class)
fun isMobile(): Boolean {
    val userAgent = window.navigator.userAgent.lowercase()
    val isMobileUserAgent = userAgent in (listOf("Android", "webOS", "iPhone", "iPad", "iPod", "BlackBerry", "IEMobile", "Opera Mini").map { it.lowercase() })
    val isTouchDevice = isTouchDevice() || window.navigator.maxTouchPoints > 0
    val isSmallScreen = window.innerWidth < 768
    return isMobileUserAgent || (isTouchDevice && isSmallScreen)
}