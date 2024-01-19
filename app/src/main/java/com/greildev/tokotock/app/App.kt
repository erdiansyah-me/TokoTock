package com.greildev.tokotock.app

import android.app.Application
import com.greildev.tokotock.app.di.repositoryModules
import com.greildev.tokotock.app.di.useCaseModules
import com.greildev.tokotock.app.di.userPreferencesModules
import com.greildev.tokotock.app.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            modules(
                repositoryModules,
                userPreferencesModules,
                useCaseModules,
                viewModelModules
            )
        }
    }
}