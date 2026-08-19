package dev.softikk.webkit

@JsModule("./isMobile.js")
actual external object Mobile {
    actual fun isMobile(): Boolean
}