package com.almondpeach.conventions.plugins

import com.almondpeach.conventions.extensions.withRoot
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.LogLevel
import org.gradle.process.internal.ExecException

@Suppress("unused")
internal class GitConfig : Plugin<Project> {
    override fun apply(target: Project) = withRoot(target) {
        tasks.getByName("prepareKotlinBuildScriptModel") {
            doLast {
                try {
                    exec { commandLine("git", "config", "--local", "include.path", "../.gitconfig") }
                } catch (cause: ExecException) {
                    logger.log(LogLevel.ERROR, "Couldn't include local git config.", cause)
                }
            }
        }
    }
}
