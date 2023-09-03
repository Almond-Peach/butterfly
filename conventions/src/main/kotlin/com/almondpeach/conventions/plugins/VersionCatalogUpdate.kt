package com.almondpeach.conventions.plugins

import com.almondpeach.conventions.extensions.plugins
import com.almondpeach.conventions.extensions.withRoot
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType

@Suppress("unused")
internal class VersionCatalogUpdate : Plugin<Project> {
    override fun apply(target: Project) = withRoot(target) {
        plugins(
            "benmanes-versions",
            "littlerobots-version-catalog-update",
        )
        tasks.withType<DependencyUpdatesTask> {
            rejectVersionIf {
                val instabilitySuffixes = listOf("dev", "alpha", "beta", "rc").map { it.lowercase() }
                val version = candidate.version.lowercase()
                val dependencyIsUnstable = instabilitySuffixes.any { version.contains(it) }
                dependencyIsUnstable
            }
        }
    }
}
