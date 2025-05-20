plugins {
    id("java")
    id ("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

dependencies {
    implementation("org.springframework:spring-context:6.1.0")
    // Для аннотаций управления жизненного цикла бина (Java 9+)
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
    // Для аннотаций управления жизненного цикла бина (Java 8)
    //implementation("javax.annotation:javax.annotation-api:1.3.2")
    // Для работы с yaml файлами
    implementation("org.yaml:snakeyaml:2.2")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set(
        if (project.hasProperty("mainClass")) {
            project.property("mainClass") as String
        } else {
            "com.github.maxain.spring.di.CafeApplication"
        }
    )
}

tasks.test {
    useJUnitPlatform()
}