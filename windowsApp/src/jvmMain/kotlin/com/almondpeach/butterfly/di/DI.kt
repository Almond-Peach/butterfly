package com.almondpeach.butterfly.di

import org.kodein.di.DI

internal val applicationModule = DI {
    import(dataModule)
}
