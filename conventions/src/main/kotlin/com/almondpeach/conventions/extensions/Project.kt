package com.almondpeach.conventions.extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

internal fun Project.plugins(vararg aliases: String): Unit = aliases.forEach { plugin(it) }

internal fun Project.plugin(alias: String): Unit = pluginManager.apply(pluginId(alias))

internal fun Project.library(alias: String): Provider<MinimalExternalModuleDependency> {
    val library = libs.findLibrary(alias)
    check(library.isPresent) { "$alias library not found" }
    return library.get()
}

private fun Project.pluginId(alias: String): String {
    val plugin = libs.findPlugin(alias)
    check(plugin.isPresent) { "$alias plugin not found" }
    return plugin.get().get().pluginId
}

private val Project.libs: VersionCatalog get() = extensions.getByType<VersionCatalogsExtension>().named("libs")
