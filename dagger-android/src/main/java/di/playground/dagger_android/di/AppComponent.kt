package di.playground.dagger_android.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import di.playground.dagger_android.DaggerAndroidApp
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        DataModule::class,
        AppModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<Application>, AppGraph {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}

interface AppGraph {

    fun inject(app: DaggerAndroidApp)
}