plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

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
}

dependencies {
    implementation(project(":domain"))
}
