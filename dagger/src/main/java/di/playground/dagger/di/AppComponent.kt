package di.playground.dagger.di

import dagger.Component
import di.playground.dagger.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class
    ]
)
interface AppComponent : AppGraph {

}

interface AppGraph {

    fun inject(mainActivity: MainActivity)
}