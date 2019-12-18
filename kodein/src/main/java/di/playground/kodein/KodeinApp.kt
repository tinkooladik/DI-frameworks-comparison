package di.playground.kodein

import android.app.Application
import di.playground.kodein.di.dataModule
import org.kodein.di.Kodein
import timber.log.Timber

class KodeinApp : Application() {

    val kodein by lazy {
        Kodein {
            import(dataModule)
        }
    }

    init {
        App = this
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}

lateinit var App: KodeinApp