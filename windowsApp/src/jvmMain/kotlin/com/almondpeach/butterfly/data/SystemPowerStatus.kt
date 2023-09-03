package com.almondpeach.butterfly.data

// todo make private again
internal fun SystemPowerStatus.getACLineStatusString(): String = when (acLineStatus) {
    0.b -> "Offline."
    1.b -> "Online."
    else -> "Unknown status."
}

// todo make private again
internal fun SystemPowerStatus.getBatteryFlagString(): String = when (batteryFlag) {
    1.b -> "High — the battery capacity is at more than 66 percent."
    2.b -> "Low — the battery capacity is at less than 33 percent."
    4.b -> "Critical — the battery capacity is at less than five percent."
    8.b -> "Charging."
    128.b -> "No system battery."
    255.b -> "Unknown status — unable to read the battery flag information."
    else -> throw IllegalStateException("BatteryFlag value set is [1, 2, 4, 8, 128, 255].")
}

// todo make private again
internal fun SystemPowerStatus.getBatteryLifePercentString(): String = when (batteryLifePercent) {
    255.b -> "Unknown status."
    in 0.b..100.b -> "$batteryLifePercent percent."
    else -> throw IllegalStateException("BatteryLifePercent value set is [0..100, 255].")
}

private fun SystemPowerStatus.getSystemStatusFlagString(): String = when (systemStatusFlag) {
    0.b -> "Battery saver is off."
    1.b -> "Battery saver on. Save energy where possible."
    else -> throw IllegalStateException("SystemStatusFlag value set is [0, 1].")
}

private fun SystemPowerStatus.getBatteryLifeTimeString(): String = when (batteryLifeTime) {
    -1 -> "Either unknown lifetime or connected to AC power."
    else -> "$batteryLifeTime seconds."
}

private fun SystemPowerStatus.getBatteryFullLifeTimeString(): String = when (batteryFullLifeTime) {
    -1 -> "Either unknown lifetime or connected to AC power."
    else -> "$batteryFullLifeTime seconds."
}

private inline val Int.b: Byte get() = this.toByte()
