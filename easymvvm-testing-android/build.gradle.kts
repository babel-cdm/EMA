plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

group = "com.github.babel-cdm"

android {
    compileSdkVersion(ProjectConfiguration.CompileSDK)
    buildToolsVersion = ProjectConfiguration.BuildTools

    defaultConfig {
        minSdkVersion(ProjectConfiguration.MinSDK)
        targetSdkVersion(ProjectConfiguration.TargetSDK)
        versionCode = ProjectConfiguration.VersionCode
        versionName = ProjectConfiguration.VersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":easymvvm-android"))
    implementation(project(":easymvvm-core"))
    implementation(project(":easymvvm-testing-core"))

    // Kotlin
    implementation(Dependencies.Common.Coroutines)
    implementation(Dependencies.Common.Kotlin)

    // Test
    implementation(Dependencies.Test.JUnit)
    implementation(Dependencies.Test.Lifecycle)
    implementation(Dependencies.Test.MockK)
    implementation(Dependencies.AndroidTest.EspressoCore)
    implementation(Dependencies.AndroidTest.JUnit)
    implementation(Dependencies.AndroidTest.Rules)
    implementation(Dependencies.AndroidTest.Runner)
}