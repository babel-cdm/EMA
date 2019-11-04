object Dependencies {

    object Project {
        const val DependencyUpdates = "com.github.ben-manes:gradle-versions-plugin:${DependencyVersion.DependencyUpdates}"
        const val Gradle = "com.android.tools.build:gradle:${DependencyVersion.Gradle}"
        const val KotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${DependencyVersion.Kotlin}"
        const val Navigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${DependencyVersion.Navigation}"
    }

    object Common {
        const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersion.Coroutines}"
        const val Kodein = "org.kodein.di:kodein-di-generic-jvm:${DependencyVersion.Kodein}"
        const val KodeinAndroid = "org.kodein.di:kodein-di-framework-android-x:${DependencyVersion.Kodein}"
        const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${DependencyVersion.Kotlin}"
    }

    object Android {
        const val AppCompat = "androidx.appcompat:appcompat:${DependencyVersion.AppCompat}"
        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:${DependencyVersion.ConstraintLayout}"
        const val CoreKtx = "androidx.core:core-ktx:${DependencyVersion.CoreKtx}"
        const val Lifecycle = "androidx.lifecycle:lifecycle-extensions:${DependencyVersion.Lifecycle}"
        const val LifecycleKapt = "androidx.lifecycle:lifecycle-compiler:${DependencyVersion.Lifecycle}"
        const val Material = "com.google.android.material:material:${DependencyVersion.Material}"
        const val NavigationFragment = "androidx.navigation:navigation-fragment-ktx:${DependencyVersion.Navigation}"
        const val NavigationUi = "androidx.navigation:navigation-ui-ktx:${DependencyVersion.Navigation}"
    }

    object Test {
        const val JUnit = "junit:junit:${DependencyVersion.JUnit}"
        const val Lifecycle = "androidx.arch.core:core-testing:${DependencyVersion.Lifecycle}"
        const val MockK = "io.mockk:mockk:${DependencyVersion.MockK}"
    }

    object AndroidTest {
        const val EspressoCore = "androidx.test.espresso:espresso-core:${DependencyVersion.Espresso}"
        const val JUnit = "androidx.test.ext:junit-ktx:${DependencyVersion.AndroidJUnit}"
        const val Rules = "androidx.test:rules:${DependencyVersion.Rules}"
        const val Runner = "androidx.test:runner:${DependencyVersion.Runner}"
    }

}