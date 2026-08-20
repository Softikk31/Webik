package dev.softikk.webkit

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@JsModule("./isMobile.js")
actual external object Mobile {
    actual fun isMobile(): Boolean
}