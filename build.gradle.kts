// Project-level build.gradle

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")  // Ensure the correct version
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")  // Kotlin plugin version
    }
}

plugins {
    id("com.android.application") version "7.3.1" apply false
    kotlin("android") version "1.8.0" apply false
}

rootProject.name = "FlashCardApplication"
include(":app")
