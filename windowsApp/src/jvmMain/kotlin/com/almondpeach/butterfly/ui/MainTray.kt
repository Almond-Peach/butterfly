package com.almondpeach.butterfly.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.rememberNotification
import androidx.compose.ui.window.rememberTrayState

@Composable
internal fun ApplicationScope.MainTray(
    icon: Painter,
    onAction: () -> Unit,
) {
    val trayState = rememberTrayState()
    val notification = rememberNotification("Notification", "Notification")

    Tray(
        icon = icon,
        onAction = onAction,
    ) {
        Item(
            text = "Notify",
        ) {
            trayState.sendNotification(notification)
        }
        Item(
            text = "Exit",
        ) {
            exitApplication()
        }
    }
}
