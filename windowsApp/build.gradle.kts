import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    // detekt
    id("com.almondpeach.detekt")
    // kotlin
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    // compose
    alias(libs.plugins.jetbrains.compose)
}

kotlin {
    jvmToolchain(17)
    jvm { withJava() }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                // compose
                implementation(compose.desktop.windows_x64)
                implementation(compose.materialIconsExtended)
                // jna
                implementation(libs.java.dev.jna)
                // kodein
                implementation(libs.kodein.di.kodein.di)
            }
        }
    }
}

compose {
    desktop {
        application {
            mainClass = "MainKt"
            nativeDistributions {
                targetFormats(TargetFormat.Msi)
                packageName = rootProject.name;
                packageVersion = rootProject.version.toString()
            }
        }
    }
}
