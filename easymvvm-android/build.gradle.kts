plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
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

    packagingOptions {
        pickFirsts = setOf(
                "META-INF/kotlinx-io.kotlin_module",
                "META-INF/easymvvm-android_debug.kotlin_module"
        )
    }
}

dependencies {
    implementation(project(":easymvvm-core"))

    // Kotlin
    implementation(Dependencies.Common.Coroutines)
    implementation(Dependencies.Common.Kotlin)

    // Kodein
    implementation(Dependencies.Common.Kodein)
    implementation(Dependencies.Common.KodeinAndroid)

    // Lifecycle
    implementation(Dependencies.Android.Lifecycle)
    kapt(Dependencies.Android.LifecycleKapt)

    // Core
    implementation(Dependencies.Android.AppCompat)
    implementation(Dependencies.Android.CoreKtx)

    // Navigation
    implementation(Dependencies.Android.NavigationFragment)
    implementation(Dependencies.Android.NavigationUi)

    // UI
    implementation(Dependencies.Android.ConstraintLayout)
    implementation(Dependencies.Android.Material)

    // Test
    testImplementation(Dependencies.Test.JUnit)
    testImplementation(Dependencies.Test.MockK)

    androidTestImplementation(project(":easymvvm-testing-android"))
}
