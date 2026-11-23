---
id: TASK-003
title: Подготовить Android-окружение и пустой каркас приложения
status: Сделано
assignee: []
created_date: '2026-11-23 14:47'
updated_date: '2026-11-23 15:03'
labels:
  - android
  - система
  - интерфейс
dependencies: []
ordinal: 3000
---

## Description

<!-- SECTION:DESCRIPTION:BEGIN -->
По запросу пользователя создать сборочную обвязку Android и запускаемое приложение без функционала. Пользователь подтвердил Kotlin, Jetpack Compose и Android 8.0+ (API 26). Один пустой экран, базовая тема, ресурсы и значок, Gradle Wrapper, каталог версий, настройка окружения и CI. Спецификация: docs/requirements/android-scaffold.md; решение: docs/architecture/decisions/0001-native-android.md. Таймер, звук, хранение, уведомления и фоновые службы не входят. TASK-002 остаётся отдельной задачей про будущий функционал.
<!-- SECTION:DESCRIPTION:END -->

## Acceptance Criteria
<!-- AC:BEGIN -->
- [x] #1 Проект импортируется в Android Studio и содержит один пустой экран без функционала
- [x] #2 Gradle Wrapper и версии зависимостей закреплены, локальные пути и секреты исключены из Git
- [x] #3 Документированы настройка JDK и SDK, команды сборки и проверки, добавлен CI
- [x] #4 Сборка debug APK и Android Lint проходят; результат запуска или ограничения среды зафиксированы
<!-- AC:END -->

## Implementation Plan

<!-- SECTION:PLAN:BEGIN -->
Проверить JDK, SDK и Gradle, изучить официальную совместимость. Получить ответ о Kotlin/Compose и minSdk, подготовить требования и ADR до кода. Создать Gradle Wrapper и каталог версий, app-модуль с пустой Activity и темой, ресурсы и манифест без разрешений. Добавить PowerShell-настройку локального окружения и GitHub Actions для lint/assembleDebug. Обновить AGENTS.md, README, карту и руководство. Собрать APK, выполнить lint, по возможности проверить запуск на отдельном эмуляторе. Проверить diff, ссылки и состав APK. Оставить TASK-003 на проверке до приёмки без коммита.
<!-- SECTION:PLAN:END -->

## Final Summary

<!-- SECTION:FINAL_SUMMARY:BEGIN -->
Создан нативный каркас Kotlin/Compose/Material 3 для Android 8.0+ без функционала: один app-модуль, пустой экран, светлая/тёмная тема, адаптивный и монохромный значок. Добавлены Gradle Wrapper 8.14.3 с SHA-256, каталог версий, .editorconfig, scripts/android-env.ps1 и GitHub Actions. Подготовлены спецификация, ADR 0001, архитектура, обновлены README, AGENTS.md, TOOLS.md, карта и руководство. TASK-002 уточнена под будущий таймер. JDK 21 и SDK 36 настроены только для локального процесса; установлен отдельный эмулятор с AOSP API 36. Проверки: :app:lintDebug и :app:assembleDebug успешны, lint 0 issues; checksum Wrapper JAR сверена с services.gradle.org; actionlint 1.7.7 успешен; 48 файлов и 77 относительных ссылок/якорей проверены, git diff --check пройден. Проверены обработка неверного пути JDK без побочных изменений и исключения локальных файлов. Debug APK 10299867 байт установлен на OneBeep_API_36 (emulator-5580); запуск, светлая/тёмная тема, поворот, возврат через Launcher и пересоздание процесса без ошибок AndroidRuntime. Скриншоты просмотрены в data/qa; эмулятор после проверки остановлен. Итоговый манифест: одна Activity, нет служб и системных uses-permission; служебное signature-разрешение AndroidX остаётся. Android Studio и устройство API 26 отдельно не запускались; GitHub Actions удалённо ещё не выполнялся. Изменения оставлены на проверке без коммита и push по AGENTS.md.

Пользователь принял результат. Карточка завершена; каркас и документация фиксируются общим коммитом с последующей отправкой по правилам Git проекта.
<!-- SECTION:FINAL_SUMMARY:END -->
