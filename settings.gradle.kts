pluginManagement {
    repositories {
        google() // Repositories for plugins
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()  // Repositories for dependencies
        mavenCentral()
    }
}

rootProject.name = "Flash Card Application"
include(":app")
