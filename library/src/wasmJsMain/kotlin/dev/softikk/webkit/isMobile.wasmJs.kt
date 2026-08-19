package dev.softikk.webkit

@OptIn(ExperimentalWasmJsInterop::class)
@JsModule("./isMobile.js")
actual external object Mobile {
    actual fun isMobile(): Boolean
}