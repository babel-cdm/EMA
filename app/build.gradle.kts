plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(ProjectConfiguration.CompileSDK)
    buildToolsVersion = ProjectConfiguration.BuildTools

    defaultConfig {
        applicationId = ProjectConfiguration.PackageName
        minSdkVersion(ProjectConfiguration.MinSDK)
        targetSdkVersion(ProjectConfiguration.TargetSDK)
        versionCode = ProjectConfiguration.VersionCode
        versionName = ProjectConfiguration.VersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    flavorDimensions("default")

    buildTypes {
        named("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }

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
        excludes = setOf(
                "META-INF/proguard/coroutines.pro",
                "META-INF/MANIFEST.MF",
                "META-INF/LICENSE",
                "META-INF/DEPENDENCIES"
        )
    }
}

dependencies {
    implementation(project(":easymvvm-android"))
    implementation(project(":easymvvm-core"))

    implementation(project(":common"))
    implementation(project(":domain"))
    implementation(project(":injection"))

    // Kotlin
    implementation(Dependencies.Common.Coroutines)
    implementation(Dependencies.Common.Kotlin)

    // Kodein
    implementation(Dependencies.Common.Kodein)
    implementation(Dependencies.Common.KodeinAndroid)

    // Core
    implementation(Dependencies.Android.AppCompat)
    implementation(Dependencies.Android.CoreKtx)

    // EmaBaseNavigator
    implementation(Dependencies.Android.NavigationFragment)
    implementation(Dependencies.Android.NavigationUi)

    // UI
    implementation(Dependencies.Android.ConstraintLayout)
    implementation(Dependencies.Android.Material)

    // Lifecycle
    implementation(Dependencies.Android.Lifecycle)
    kapt(Dependencies.Android.LifecycleKapt)
}
