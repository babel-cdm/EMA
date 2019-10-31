import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.github.ben-manes.versions") version DependencyVersion.DependencyUpdates
}

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(Dependencies.Project.DependencyUpdates)
        classpath(Dependencies.Project.Gradle)
        classpath(Dependencies.Project.KotlinGradle)
        classpath(Dependencies.Project.Navigation)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

subprojects {
    tasks {
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
}

tasks {
    register<Delete>("clean") {
        description = "Delete all build directories of each project"
        group = "build"

        delete(buildDir)
        subprojects.forEach { sp ->
            delete(sp.buildDir)
        }
    }

    withType<DependencyUpdatesTask> {
        rejectVersionIf {
            candidate.version.isNonStable() && !currentVersion.isNonStable()
        }
    }
}