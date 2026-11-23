# Устройство Android-каркаса

Минимальная структура One Beep без бизнес-логики. Границы — в [требованиях](../requirements/android-scaffold.md), выбор стека — в [ADR 0001](decisions/0001-native-android.md).

```mermaid
flowchart LR
    launcher[Android Launcher] --> activity[MainActivity]
    activity --> app[OneBeepApp]
    app --> theme[OneBeepTheme]
    theme --> surface[Пустая Surface]
```

| Путь | Назначение |
| --- | --- |
| `app/src/main/AndroidManifest.xml` | Единственная стартовая Activity, тема, имя, значок и отключённое резервное копирование; без запросов системных разрешений |
| `app/src/main/java/io/github/smilingjey/onebeep/MainActivity.kt` | Вход Android и подключение Compose |
| `app/src/main/java/io/github/smilingjey/onebeep/ui/OneBeepApp.kt` | Корневой composable с пустой поверхностью |
| `app/src/main/java/io/github/smilingjey/onebeep/ui/theme/Theme.kt` | Светлая и тёмная цветовые схемы |
| `app/src/main/res/` | Имя приложения, платформенная тема и адаптивный значок |
| `gradle/` | Каталог версий и Wrapper |
| `scripts/android-env.ps1` | Проверка и настройка JDK/SDK в текущем PowerShell |
| `.github/workflows/android.yml` | Сборка debug APK и Android Lint |

Нет собственного состояния, сервисов, хранилища и контрактов данных. Итоговый манифест также содержит стандартные компоненты зависимостей AndroidX (инициализация, установка профиля производительности и внутреннее signature-разрешение); они не реализуют таймер и не запрашивают разрешения у пользователя.

Вопросы таймера из [продуктовых требований](../requirements/application.md) остаются открытыми. Инструкции сборки и проверки — в [руководстве разработчика](../guides/development.md).
