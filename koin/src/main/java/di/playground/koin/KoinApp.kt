package di.playground.koin

import android.app.Application
import di.playground.koin.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class KoinApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApp)
            modules(listOf(dataModule))
        }

        Timber.plant(Timber.DebugTree())
    }
}