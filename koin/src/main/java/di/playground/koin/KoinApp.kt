package di.playground.koin

import android.app.Application
import di.playground.koin.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.Koin
import org.koin.core.context.startKoin
import timber.log.Timber

class KoinApp : Application() {

    companion object {
        lateinit var koin: Koin
    }

    override fun onCreate() {
        super.onCreate()

        koin = startKoin {
            androidContext(this@KoinApp)
            modules(
                listOf(
                    dataModule,
                    scopeModule,
                    qualifierModule,
                    androidModule,
                    multibindingModule
                )
            )
        }.koin

        Timber.plant(Timber.DebugTree())
    }
}