plugins {
    kotlin("jvm")
}

dependencies {
    implementation(Dependencies.Common.Coroutines)
    implementation(Dependencies.Common.Kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}