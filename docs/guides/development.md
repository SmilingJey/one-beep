# Разработка и проверка Android-приложения

Настройка окружения, сборка и приёмка пустого каркаса. Выбор стека — в [ADR 0001](../architecture/decisions/0001-native-android.md), структура — в [описании архитектуры](../architecture/android-scaffold.md).

## Инструменты

- JDK 21; `JAVA_HOME` должен указывать на JDK, содержащий `bin/java` и `bin/javac`.
- Android SDK: Platform 36 (`platforms;android-36`), Build Tools 35.0.0 (`build-tools;35.0.0`); для установки APK — `platform-tools`.
- Android Studio с поддержкой AGP 8.13 либо CLI. Глобальный Gradle не нужен: проект содержит Wrapper.
- Git и Backlog.md для ведения работ. Backlog CLI проверен на версии 1.53.0.

Версии плагинов и библиотек — в [каталоге](../../gradle/libs.versions.toml), Gradle и SHA-256 дистрибутива — в [свойствах Wrapper](../../gradle/wrapper/gradle-wrapper.properties). Первый запуск скачивает Gradle и зависимости из официальных репозиториев.

Недостающие SDK-компоненты устанавливаются через SDK Manager в Android Studio либо `sdkmanager` из Android SDK Command-line Tools. Пример при уже настроенном JDK 21:

```powershell
& "$env:ANDROID_HOME\cmdline-tools\latest\bin\sdkmanager.bat" 'platforms;android-36' 'build-tools;35.0.0' 'platform-tools'
```

## Настройка в Windows

Из корня проекта, если `JAVA_HOME` и `ANDROID_HOME` уже заданы:

```powershell
.\scripts\android-env.ps1
```

Для явного выбора установленных инструментов:

```powershell
.\scripts\android-env.ps1 -JdkPath 'C:\path\to\jdk-21' -SdkPath 'C:\path\to\android-sdk'
```

Скрипт проверяет JDK и SDK-компоненты, создаёт игнорируемый `local.properties` и задаёт `JAVA_HOME`, `ANDROID_HOME`, `Path` только в текущем PowerShell. Глобальные переменные Windows не меняются. Команды сборки выполняй в том же окне. В новом окне повтори настройку; пути конкретного компьютера не входят в проект.

## Android Studio

Открой корень проекта, выбери JDK 21 в настройках Gradle JVM, укажи Android SDK и дождись Gradle Sync. Выбери конфигурацию `app`, отдельный эмулятор или выделенное тестовое устройство, затем Run. В IDE JDK настраивается отдельно от переменных PowerShell.

## CLI и обязательные проверки

```powershell
.\gradlew.bat :app:lintDebug :app:assembleDebug
```

На Linux/macOS после настройки JDK и SDK:

```sh
./gradlew :app:lintDebug :app:assembleDebug
```

Kotlin компилируется с ошибкой на предупреждения; Android Lint также считает предупреждения ошибками. Отключены только информационные проверки наличия новых версий (`AndroidGradlePluginVersion`, `GradleDependency`, `NewerVersionAvailable`): зависимости обновляются совместно с проверкой совместимости, а выход новой версии не должен ломать сборку закреплённого каркаса. Компиляция входит в сборку.

Отдельных средств форматирования пока нет; соглашения заданы `.editorconfig` и Kotlin official style. Проверка пробелов — `git diff --check` (для новых файлов нужен отдельный просмотр или intent-to-add).

Результаты:

- `app/build/outputs/apk/debug/app-debug.apk` — debug APK с отладочной подписью, без ключей публикации.
- `app/build/reports/lint-results-debug.html` и `.xml` — отчёт Android Lint.

Функциональных и UI-автотестов пока нет: каркас не содержит бизнес-логики. При изменениях только документации тесты и сборку не запускаем. При изменениях кода или сборочной конфигурации выполняем обе обязательные задачи выше.

## Ручная приёмка

Используй отдельный эмулятор или выделенное тестовое устройство; личный телефон пользователя не подключается автоматически. При нескольких устройствах явно укажи серийный номер через `adb -s <serial>`.

```powershell
adb devices
adb -s <serial> install -r app/build/outputs/apk/debug/app-debug.apk
adb -s <serial> shell am start -W -n io.github.smilingjey.onebeep/.MainActivity
```

Ожидаемый результат: приложение One Beep открывает пустой экран в цвете системной светлой или тёмной темы. Видны только системные панели. Нет кнопок, отсчёта, звука, демонстрационных надписей и запросов разрешений.

Проверь возврат через Launcher, поворот экрана, смену светлой/тёмной темы и пересоздание Activity без сбоя. Зафиксируй версию Android и непроведённые проверки. Установка APK подтверждает установку, а не успешный запуск и визуальную проверку.

## CI

[GitHub Actions](../../.github/workflows/android.yml) при push в `main` и pull request настраивает JDK/SDK, проверяет Wrapper через Gradle action и выполняет те же задачи lint и debug-сборки. APK и отчёты сохраняются артефактом `one-beep-debug`. Также доступен ручной запуск workflow.

Удалённый CI можно проверить после принятия изменения и отправки в репозиторий. Локальный успешный запуск не выдаётся за уже прошедший GitHub Actions. Публикация в магазин и release-подпись пока не настроены.

## Очередь и Git

Правила работы — в [AGENTS.md](../../AGENTS.md), очередь — в [руководстве Backlog](../../backlog/README.md). Перед коммитом нужна приёмка изменений приложения пользователем. Каркас и документация входят в один коммит.

```powershell
git status --short --branch
backlog task list --plain
```
