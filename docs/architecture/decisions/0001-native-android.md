# ADR 0001 — Нативный Android-каркас на Kotlin и Compose

**Статус:** Accepted

## Контекст

Нужно подготовить запускаемую основу Android-приложения без таймера и звука. Пользователь подтвердил Kotlin, Jetpack Compose и минимальную версию Android 8.0. Требования — в [спецификации каркаса](../../requirements/android-scaffold.md).

Кроссплатформенная оболочка не требуется: согласована одна платформа. XML Views — возможная альтернатива, но для нового интерфейса выбран Compose. Установленные SDK 36 и JDK 21 позволяют проверить сборку локально.

## Решение

- Нативное приложение на Kotlin с Jetpack Compose и Material 3, один модуль `app`.
- Минимальная версия Android — API 26; compileSdk и targetSdk — 36 для текущего каркаса.
- Для воспроизводимого старта используем консервативный совместимый набор: AGP 8.13.2, Gradle 8.14.3, Kotlin и Compose Compiler 2.2.21, Compose BOM 2025.10.01, Activity Compose 1.11.0. Это закреплённая исходная база, а не заявление о самых новых версиях.
- Среда сборки — JDK 21, целевой JVM bytecode — 17. Android SDK Build Tools — 35.0.0, требуемый этой веткой AGP по умолчанию.
- Версии зависимостей задаются в `gradle/libs.versions.toml`; версия Gradle и SHA-256 — в свойствах Wrapper.
- Предварительный application ID и namespace — `io.github.smilingjey.onebeep`. До публикации его можно пересмотреть; идентификатор не определяет способ будущего распространения.
- Activity только подключает Compose; корневой composable создаёт пустую поверхность в светлой или тёмной теме. Доменные слои и системные интеграции появятся вместе с соответствующими требованиями.

Совместимость проверяется по [AGP 8.13](https://developer.android.com/build/releases/agp-8-13-0-release-notes), [Kotlin Gradle](https://kotlinlang.org/docs/gradle-configure-project.html), [Compose Compiler](https://developer.android.com/develop/ui/compose/setup-compose-dependencies-and-compiler) и фактической сборке. Библиотеки Compose согласуются через [BOM](https://developer.android.com/develop/ui/compose/bom).

## Последствия

- Небольшой каркас можно открыть в Android Studio и собрать из CLI без глобального Gradle.
- Нет дополнительных фреймворков, DI, базы данных и навигации, которые пока не решают задачу.
- JDK и SDK устанавливаются отдельно; первая сборка требует сети для зависимостей.
- Фоновое выполнение, точность таймера, звук и разрешения остаются отдельными решениями после уточнения продуктовых требований.
- Перед публикацией или переходом на новый SDK нужно пересмотреть targetSdk и совместимость закреплённых инструментов.
