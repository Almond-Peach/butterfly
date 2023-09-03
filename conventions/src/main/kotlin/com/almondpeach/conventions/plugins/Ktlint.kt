package com.almondpeach.conventions.plugins

import com.almondpeach.conventions.extensions.library
import com.almondpeach.conventions.extensions.withRoot
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.attributes.Bundling
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.register
import org.gradle.language.base.plugins.LifecycleBasePlugin

@Suppress("unused")
internal class Ktlint : Plugin<Project> {
    override fun apply(target: Project) = withRoot(target) {
        val ktlint: Configuration by configurations.creating

        dependencies {
            ktlint(library("pinterest-ktlint")) {
                attributes { attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL)) }
            }
        }

        tasks.register("ktlintCheck", JavaExec::class) {
            group = LifecycleBasePlugin.VERIFICATION_GROUP
            description = "Run ktlint code style check"
            classpath = ktlint
            mainClass.set(KTLINT_MAIN_CLASS)
            args(CHECK_KT, CHECK_KTS, IGNORE_BUILD)
        }

        tasks.register("ktlintFormat", JavaExec::class) {
            group = LifecycleBasePlugin.VERIFICATION_GROUP
            description = "Run ktlint code style format"
            classpath = ktlint
            mainClass.set(KTLINT_MAIN_CLASS)
            jvmArgs("--add-opens=java.base/java.lang=ALL-UNNAMED")
            args("--format", CHECK_KT, CHECK_KTS, IGNORE_BUILD)
        }
    }

    private companion object {
        private const val KTLINT_MAIN_CLASS: String = "com.pinterest.ktlint.Main"
        private const val CHECK_KT: String = "**/src/**/*.kt"
        private const val CHECK_KTS: String = "**.kts"
        private const val IGNORE_BUILD: String = "!**/build/**"
    }
}
