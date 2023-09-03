package com.almondpeach.conventions.extensions

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Calls the specified function [block] with the given [rootProject] as its receiver.
 */
internal fun Plugin<Project>.withRoot(
    rootProject: Project,
    block: Project.() -> Unit,
) {
    requireRoot(rootProject)
    rootProject.block()
}

/**
 *  @throws IllegalArgumentException if the specified [project] is not the root project.
 */
private fun Plugin<Project>.requireRoot(project: Project) {
    require(project == project.rootProject) { "Plugin `${this::class.simpleName}` is meant for the root project only." }
}
