# ReqresProject

Este proyecto implementa pruebas de automatización para servicios REST, desarrollado con **Serenity BDD** y gestionado en **Gradle**.

## Descripción

**ReqresProject** es un conjunto de pruebas automatizadas que verifica la funcionalidad de los servicios de la API ReqRes, permitiendo pruebas de creación, actualización y eliminación de usuarios, entre otros. Las pruebas están desarrolladas con el patrón **Screenplay** de Serenity, usando Gherkin para una mayor legibilidad de los escenarios y pasos de prueba.

## Requisitos

- **JDK**: Versión 17.
- **Gradle**: Configurado en el proyecto con las dependencias necesarias.
- **ChromeDriver**: Requiere la versión 130.0.6723.91 de ChromeDriver para la ejecución de pruebas en navegador Chrome. Asegúrate de que el driver esté en el PATH o configura la ubicación del ejecutable en las propiedades del sistema.

## Dependencias

Las dependencias están definidas en el archivo `build.gradle`, incluyendo:

```gradle
apply plugin: 'java'
apply plugin: 'net.serenity-bdd.aggregator'
apply plugin: 'idea'

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath("net.serenity-bdd:serenity-gradle-plugin:2.0.89")
    }
}

ext {
    serenityVersion = '4.2.6'
    serenityCucumberVersion = '4.2.6'
}

dependencies {
    implementation 'junit:junit:4.13.2'
    implementation "net.serenity-bdd:serenity-core:$serenityVersion"
    implementation "net.serenity-bdd:serenity-junit:$serenityVersion"
    implementation "net.serenity-bdd:serenity-screenplay:$serenityVersion"
    implementation "net.serenity-bdd:serenity-screenplay-rest:$serenityVersion"
    implementation "net.serenity-bdd:serenity-cucumber:$serenityCucumberVersion"

    testImplementation 'org.assertj:assertj-core:3.24.2'
    testImplementation 'org.slf4j:slf4j-simple:1.7.36'
}
```

## Ejecución

Para ejecutar las pruebas, usa el siguiente comando en la terminal:

```bash
gradle clean test aggregate
```

Esto generará un reporte de Serenity en `target/site/serenity`, donde podrás revisar los detalles de cada prueba ejecutada.
