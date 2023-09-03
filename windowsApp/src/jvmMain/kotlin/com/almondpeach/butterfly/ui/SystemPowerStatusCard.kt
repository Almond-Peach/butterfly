package com.almondpeach.butterfly.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.almondpeach.butterfly.data.SystemPowerStatus
import com.almondpeach.butterfly.data.getACLineStatusString
import com.almondpeach.butterfly.data.getBatteryFlagString
import com.almondpeach.butterfly.data.getBatteryLifePercentString

@Composable
internal fun SystemPowerStatusCard(
    systemPowerStatus: SystemPowerStatus,
) {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "ac line status: ${systemPowerStatus.getACLineStatusString()}")
            Text(text = "battery flag: ${systemPowerStatus.getBatteryFlagString()}")
            Text(text = "battery life percent: ${systemPowerStatus.getBatteryLifePercentString()}")
        }
    }
}
