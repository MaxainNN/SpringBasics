## Проект для изучения основ Spring

### Описание

Проект для изучения `Spring Core`. В каждом пакете `spring`
отдельное приложение для изучения базовых понятий.

### Стэк

- `Java` <img src='images/java_icon.png' height=28 width=28> - 17
- `Gradle` <img src='images/gradle_icon.svg' height=28 width=28> - 8.4
- `Spring framework` <img src='images/spring_icon.png' height=28 width=28> - 6.1.0
- `JUnit` <img src='images/junit_icon_true.svg' height=28 width=28> - 5.9.1
- `Jakarta` <img src='images/jakarta_icon.png' height=28 width=28> - 2.1.1

### Структура

```text
└── spring
    ├── basic # Базовые классы и аннотации для запуска приложения
    ├── di # Dependency injection
    ├── scope # Scopes
    ├── lifecycle # Bean's lifecycle
    ├── aware # Aware interfaces
    ├── postprocessor # Bean's postprocessors
    ├── props # Application properties
    ├── spel # Spel expressions
    ├── profile # Profile / Lazy
    ├── event # Events / EventListener
    ├── proxy # Proxy pattern
    └── application # Final application
```

### Команды :
```bash
./gradlew run # Запуск класса из пакета application (По умолчанию для таски "run")
./gradlew run -PmainClass="com.github.maxain.spring.di.CafeApplication" # Запуск из пакета "di"
./gradlew run -PmainClass="com.github.maxain.spring.scope.RestaurantApplication" # Запуск метода из класса "scope"
./gradlew run -PmainClass="com.github.maxain.spring.lifecycle.Main" # Запуск из пакета "lifecycle"
./gradlew run -PmainClass="com.github.maxain.spring.aware.Main" # Запуск из пакета "aware"
./gradlew run -PmainClass="com.github.maxain.spring.postprocessor.Main" # Запуск из пакета "postprocessor"
./gradlew run -PmainClass="com.github.maxain.spring.props.Main" # Запуск из пакета "props"
./gradlew run -PmainClass="com.github.maxain.spring.spel.Main" # Запуск из пакета "spel"
./gradlew run -PmainClass="com.github.maxain.spring.profile.Main" # Запуск из пакета "profile"
./gradlew run -PmainClass="com.github.maxain.spring.event.Main" # Запуск из пакета "event"
./gradlew run -PmainClass="com.github.maxain.spring.proxy.Main" # Запуск из пакета "proxy"
```

### Описание финального приложения в пакете `application`

Приложение представляет собой менеджер списка задач 
(`To-Do List`) с возможностью:
- Добавления новых задач
- Отметки задач как завершенных
- Сохранения задач в файл
- Получения актуального списка задач

Реализация использует возможности :
`EventListener`, `Profile`, `PropertySource`, `PostContruct`.

### Версии `Java` и `Gradle`

Для того , чтобы изменить версию `Java`:

Скачать `JDK` и указать путь `JAVA_HOME` в переменных окружения
(Пример для `PowerShell`)

```text
$env:JAVA_HOME = "C:\Program Files\Java\jdk-22"
```

Для того , чтобы изменить версию `Gradle`:

В файле `gradle-wrapper.properties` указать актуальную версию `Gradle` (8.6+)

```text
distributionUrl=https\://services.gradle.org/distributions/gradle-8.6-bin.zip
```

Или выполнить комманду :

```bash
./gradlew wrapper --gradle-version=8.6
```

### Первый запуск класса в пакете `basic`: 

<img src="images/16.05_spring_base_init.png" width="500" height="300">

### Dependency injection:

<img src="images/di_spring.png" width="500" height="325">

### Scopes

<img src="images/scope_spring.webp" height="250" width="500">

### Жизненный цикл бина :

<img src="images/Spring-Bean-Life-cycle-Flow.png" height="360" width="500">

### Инициализация бина:

<img src="images/init_bean_portproc.webp" width="751" height="461">

### Application with Bean's postprocessors (package - postprocessor)

<img src="images/19.05_spring_postpr_output.png" height="300" width="600">

### Документация:
- [Gradle](https://docs.gradle.org/current/userguide/userguide.html)
- [JUnit](https://junit.org/junit5/docs/current/user-guide/)
- [Spring framework](https://docs.spring.io/spring-framework/reference/overview.html)
- [Jakarta](https://jakarta.ee/learn/docs/jakartaee-tutorial/current/index.html)

### Автор - Калугин Максим