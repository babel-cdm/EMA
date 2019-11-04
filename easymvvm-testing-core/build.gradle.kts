plugins {
    kotlin("jvm")
}

group = "com.github.babel-cdm"

dependencies {
    implementation(project(":easymvvm-core"))

    // Kotlin
    implementation(Dependencies.Common.Coroutines)
    implementation(Dependencies.Common.Kotlin)

    // Test
    implementation(Dependencies.Test.JUnit)
    implementation(Dependencies.Test.Lifecycle)
    implementation(Dependencies.Test.MockK)
}
