package com.angoga.kfd_workshop_mobile

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import com.angoga.kfd_workshop_mobile.di.appModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}