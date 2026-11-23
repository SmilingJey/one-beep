# Карта документации

Точка входа в знания о One Beep. Документы отделяют подтверждённые требования от открытых вопросов и ещё не принятых решений.

## С чего начать

| Вопрос | Документ |
| --- | --- |
| Что это за проект и в каком он состоянии | [Корневой README](../README.md) |
| Как работает агент, кто принимает решения и результат | [AGENTS.md](../AGENTS.md) |
| Какие особенности инструментов проверены | [TOOLS.md](../TOOLS.md) |
| Где задачи, планы и результаты проверок | [Руководство Backlog](../backlog/README.md) |
| Что подтверждено о приложении, что нужно уточнить | [Требования к приложению](requirements/application.md) |
| Что входит в организационную обвязку | [Требования к обвязке](requirements/project-setup.md) |
| Что входит в пустой Android-каркас | [Требования каркаса](requirements/android-scaffold.md) |
| Как устроены модуль и экран | [Архитектура каркаса](architecture/android-scaffold.md) |
| Почему выбраны Kotlin, Compose и Android 8+ | [ADR 0001](architecture/decisions/0001-native-android.md) |
| Как работать с текущим репозиторием | [Руководство разработчика](guides/development.md) |
| Как принимать и пересматривать архитектурные решения | [Индекс ADR](architecture/decisions/README.md) |
| Как оформить новый ADR | [Шаблон ADR](architecture/decisions/template.md) |

## Существующие разделы

- `requirements/`: [application.md](requirements/application.md) — продуктовые требования и открытые вопросы; [project-setup.md](requirements/project-setup.md) — границы первичной организационной обвязки; [android-scaffold.md](requirements/android-scaffold.md) — пустое приложение и сборочная основа.
- `guides/`: [development.md](guides/development.md) — доступные инструменты, навигация, проверки и состояние Git.
- `architecture/`: [android-scaffold.md](architecture/android-scaffold.md) — модуль, точка входа, Compose-корень, тема и инструменты.
- `architecture/decisions/`: [README.md](architecture/decisions/README.md) — правила и реестр ADR; [template.md](architecture/decisions/template.md) — шаблон; [0001-native-android.md](architecture/decisions/0001-native-android.md) — принятый выбор Kotlin, Compose и Android 8+.

## Как расширять документацию

Создавай раздел при появлении содержимого и добавляй каждый документ в карту. Описания хранения, таймера и звука появятся после соответствующих решений и реализации. Не создавай пустые разделы, выдуманные контракты или описание будущей реализации как существующей.

Методология — в [AGENTS.md](../AGENTS.md#работа-с-документацией). Планы и история работ — в карточках Backlog.
