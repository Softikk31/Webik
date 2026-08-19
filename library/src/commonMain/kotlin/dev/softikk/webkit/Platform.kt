package dev.softikk.webkit

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform