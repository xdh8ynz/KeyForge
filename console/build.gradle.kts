plugins {
    kotlin("jvm")
    id("org.jlleitschuh.gradle.ktlint")
}

group = "my.xdh8ynz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}
