package di.playground.kodein

import android.app.Application
import di.playground.kodein.di.*
import org.kodein.di.Kodein
import org.kodein.di.android.x.androidXModule
import timber.log.Timber

class KodeinApp : Application() {

    val kodein by lazy {
        Kodein {
            import(dataModule)
            import(scopeModule)
            import(qualifierModule)
            import(myAndroidModule)
            import(multibindingModule)

            /*
            Kodein-DI-Android proposes a Module that enables easy retrieval of a lot of standard android services.
            Can either be androidXModule or androidSupportModule or androidCoreModule.
            You can see everything that this module proposes in the Kodein-Android module.kt file:
            https://github.com/Kodein-Framework/Kodein-DI/blob/6.1/framework/android/kodein-di-framework-android-core/src/main/java/org/kodein/di/android/module.kt
             */
            import(androidXModule(this@KodeinApp))
            /*
            The android module provides a number of context translators. For example, they allow
             you to retrieve an activity scoped singleton inside a fragment,
             without manually specifying the activity.
             However, if you don’t want to use the android modules, but still need these translators,
             you can register them easily:
            */
            // import(androidXContextTranslators)
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