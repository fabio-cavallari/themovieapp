package common

import android.app.Application
import common.di.MovieAppModules.movieAppModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(movieAppModules)
        }
    }
}