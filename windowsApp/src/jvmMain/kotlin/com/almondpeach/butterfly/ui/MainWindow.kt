package com.almondpeach.butterfly.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.rememberWindowState
import com.almondpeach.butterfly.data.SystemPowerStatus
import com.almondpeach.butterfly.data.SystemPowerStatusRepo
import com.almondpeach.butterfly.di.applicationModule
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.kodein.di.instance

@Composable
internal fun MainWindow(
    state: WindowState = rememberWindowState(width = 300.dp, height = 300.dp),
    title: String = "Butterfly",
    icon: Painter,
    onCloseRequest: () -> Unit,
) {
    var systemPowerStatus by remember { mutableStateOf(SystemPowerStatus()) }

    LaunchedEffect(Unit) {
        launch {
            val systemPowerStatusRepo: SystemPowerStatusRepo by applicationModule.instance()
            while (true) {
                systemPowerStatus = systemPowerStatusRepo.getSystemPowerStatus()
                delay(5_000L)
            }
        }
    }

    Window(
        onCloseRequest = onCloseRequest,
        state = state,
        title = title,
        icon = icon,
    ) {
        SystemPowerStatusCard(systemPowerStatus = systemPowerStatus)
    }
}
