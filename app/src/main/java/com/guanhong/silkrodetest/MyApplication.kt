package com.guanhong.silkrodetest

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication: Application() {

    private val myModule = module {
        single { MainViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {

            modules(myModule)
        }
    }
}