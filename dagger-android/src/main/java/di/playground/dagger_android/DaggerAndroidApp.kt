package di.playground.dagger_android

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import di.playground.dagger_android.di.AppComponent
import di.playground.dagger_android.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

class DaggerAndroidApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)

        Timber.plant(Timber.DebugTree())
    }

    override fun activityInjector() = dispatchingAndroidInjector
}