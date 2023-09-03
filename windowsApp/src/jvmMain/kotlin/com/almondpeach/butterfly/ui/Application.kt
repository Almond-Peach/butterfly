package com.almondpeach.butterfly.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.rememberVectorPainter

internal fun application() = androidx.compose.ui.window.application {
    val mainIcon = rememberVectorPainter(Icons.Filled.Notifications)
    var openMainWindow by remember { mutableStateOf(true) }

    MainTray(icon = mainIcon) { openMainWindow = true }
    if (openMainWindow) MainWindow(icon = mainIcon) { openMainWindow = false }
}
