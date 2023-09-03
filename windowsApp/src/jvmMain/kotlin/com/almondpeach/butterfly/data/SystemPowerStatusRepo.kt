package com.almondpeach.butterfly.data

internal interface SystemPowerStatusRepo {
    fun getSystemPowerStatus(): SystemPowerStatus
}

internal class SystemPowerStatusRepoImpl(
    private val kernel32: Kernel32,
) : SystemPowerStatusRepo {
    override fun getSystemPowerStatus(): SystemPowerStatus =
        SystemPowerStatus().also { kernel32.getSystemPowerStatus(it) }
}
