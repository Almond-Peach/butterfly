package com.almondpeach.conventions.plugins

import com.almondpeach.conventions.extensions.plugin
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

@Suppress("unused")
internal class Detekt : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugin("arturbosch-detekt")
        detekt {
            parallel = true
            source.setFrom(
                files(
                    DetektExtension.DEFAULT_SRC_DIR_KOTLIN,
                    DetektExtension.DEFAULT_TEST_SRC_DIR_KOTLIN,
                    ".",
                ),
            )
            config.setFrom(files("$rootDir/detekt.yml"))
            buildUponDefaultConfig = true
            allRules = false
            disableDefaultRuleSets = false
            debug = false
            ignoreFailures = false
            ignoredBuildTypes = listOf()
            ignoredFlavors = listOf()
            ignoredVariants = listOf()
            basePath = rootDir.parentFile.canonicalPath
        }
        tasks.withType<Detekt>().configureEach {
            reports {
                html {
                    required.set(true)
                    outputLocation.set(file("build/reports/detekt.html"))
                }
                xml { required.set(false) }
                txt { required.set(false) }
                sarif { required.set(false) }
                md { required.set(false) }
            }
        }
    }
}

private fun Project.detekt(block: DetektExtension.() -> Unit): DetektExtension =
    extensions.getByType<DetektExtension>().apply(block)
