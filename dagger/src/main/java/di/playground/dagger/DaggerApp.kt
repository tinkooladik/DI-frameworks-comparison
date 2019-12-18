package di.playground.dagger

import android.app.Application
import di.playground.dagger.di.DaggerAppComponent
import timber.log.Timber

class DaggerApp : Application() {

    val component by lazy { DaggerAppComponent.create() }

    init {
        App = this
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}

lateinit var App: DaggerApp