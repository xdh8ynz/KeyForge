plugins {
    kotlin("jvm") version "2.4.21"
    id("org.jlleitschuh.gradle.ktlint") version "14.2.0"
}

group = "my.xdh8ynz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
