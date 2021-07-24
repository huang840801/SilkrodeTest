package com.guanhong.silkrodetest

import android.app.Application
import com.guanhong.silkrodetest.view.user.UserViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication: Application() {

    private val myModule = module {
        single { UserViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {

            modules(myModule)
        }
    }
}