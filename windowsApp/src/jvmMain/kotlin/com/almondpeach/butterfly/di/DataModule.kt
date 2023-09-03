package com.almondpeach.butterfly.di

import com.almondpeach.butterfly.data.Kernel32
import com.almondpeach.butterfly.data.SystemPowerStatusRepo
import com.almondpeach.butterfly.data.SystemPowerStatusRepoImpl
import com.sun.jna.FunctionMapper
import com.sun.jna.Library
import com.sun.jna.Native
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

internal val dataModule by DI.Module {
    bindSingleton<Kernel32> { kernel32 }
    bindSingleton<SystemPowerStatusRepo> { SystemPowerStatusRepoImpl(instance()) }
}

private val kernel32: Kernel32
    get() = Native.load(
        "Kernel32",
        Kernel32::class.java,
        mutableMapOf(
            Library.OPTION_FUNCTION_MAPPER to FunctionMapper { _, method ->
                method.name.replaceFirstChar(Char::uppercase)
            },
        ),
    )
