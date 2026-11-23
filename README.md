# One Beep

Простое Android-приложение: пользователь задаёт время ожидания, а по его истечении приложение издаёт звуковой сигнал, который заканчивается сам. Выключать сигнал вручную не требуется.

Репозиторий: [SmilingJey/one-beep](https://github.com/SmilingJey/one-beep).

## Статус

Создан пустой Android-каркас: один экран без содержимого, светлая и тёмная темы, значок, сборка через Gradle Wrapper и CI. Таймер, звук и другие функции пока не реализованы.

Подтверждённая идея и вопросы до реализации таймера — в [требованиях к приложению](docs/requirements/application.md). Границы каркаса — в [его спецификации](docs/requirements/android-scaffold.md).

## Технологический стек

Android 8.0+ (API 26), Kotlin, Jetpack Compose и Material 3. Среда сборки — JDK 21, compileSdk/targetSdk — 36. Версии библиотек и плагинов закреплены в [каталоге](gradle/libs.versions.toml), Gradle — в Wrapper. Причины выбора — в [ADR 0001](docs/architecture/decisions/0001-native-android.md). Механизм выполнения таймера пока не выбран.

## Быстрый старт

Откройте корень проекта в Android Studio, выберите JDK 21 для Gradle и установите Android SDK Platform 36 и Build Tools 35.0.0. Дождитесь синхронизации и запустите `app` на эмуляторе или выделенном тестовом устройстве.

В PowerShell с установленными JDK/SDK:

```powershell
# JAVA_HOME указывает на JDK 21, ANDROID_HOME — на Android SDK.
.\scripts\android-env.ps1
.\gradlew.bat :app:lintDebug :app:assembleDebug
```

Debug APK: `app/build/outputs/apk/debug/app-debug.apk`. Подробная настройка, явное указание путей и сценарии проверки — в [руководстве разработчика](docs/guides/development.md).

## Ведение проекта

- [AGENTS.md](AGENTS.md) — правила разработки, документации, проверок и Git.
- [CLAUDE.md](CLAUDE.md) — импорт общих инструкций агента.
- [docs/README.md](docs/README.md) — карта документации и точка входа.
- [backlog/README.md](backlog/README.md) — очередь работ и порядок приёмки.
- [TOOLS.md](TOOLS.md) — проверенные особенности инструментов.
- [Руководство разработчика](docs/guides/development.md) — работа с текущей обвязкой и границы доступных проверок.
