## Webik
**Webik** - это **KMP** библиотека для максимально легкой разработки web-приложений на **Compose**.

Установка:

```kotlin
repositories {
	maven { url = uri("https://jitpack.io") }
}
```

В `commonMain`
```kotlin
implementation("com.github.Softikk31.Webik:webik:1.0.0")
```

Другие
```kotlin
// js
implementation("com.github.Softikk31.Webik:webik-js:1.0.0")

// wasmJs
implementation("com.github.Softikk31.Webik:webik-wasmJs:1.0.0")
```
