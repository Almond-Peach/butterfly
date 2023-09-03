group = "com.almondpeach"
version = "0.0.1"

plugins {
    // version catalog update
    alias(libs.plugins.benmanes.versions) apply false
    alias(libs.plugins.littlerobots.version.catalog.update) apply false
    id("com.almondpeach.version.catalog.update")
    // git config
    id("com.almondpeach.git.config")
    // ktlint
    id("com.almondpeach.ktlint")
    // detekt
    alias(libs.plugins.arturbosch.detekt) apply false
    id("com.almondpeach.detekt")
    // kotlin
    alias(libs.plugins.jetbrains.kotlin.multiplatform) apply false
    // compose
    alias(libs.plugins.jetbrains.compose) apply false
}
