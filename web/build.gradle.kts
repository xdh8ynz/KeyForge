plugins {
    kotlin("jvm")
    id("org.jlleitschuh.gradle.ktlint")
    application
}

group = "my.xdh8ynz"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("my.xdh8ynz.MainKt")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-client-core-jvm:3.6.0")
    implementation("io.ktor:ktor-server-core-jvm:3.6.0")
    implementation("io.ktor:ktor-server-netty:3.6.0")
    implementation("org.slf4j:slf4j-simple:2.0.18")

    implementation(project(":core"))
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}
