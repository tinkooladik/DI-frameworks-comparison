package di.playground.koin.di

import di.playground.core.data.*
import di.playground.koin.R
import di.playground.koin.ui.AndroidActivity
import di.playground.koin.ui.AndroidViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Android specific features
 */

val androidModule = module {

    /*
    The androidContext() & androidApplication() functions allows you to get the Context instance
    in a Koin module, to help you simply write expression that requires the Application instance.
     */

    factory {
        StringHolder(androidContext().resources.getString(R.string.app_name))
    }

    /*
    Activity, Fragment & Service are extended with the KoinComponents extension. You gain access to:
        * by inject() - lazy evaluated instance from Koin container
        * get() - eager fetch instance from Koin container
        * release() - release module’s instances from its path
        * getProperty()/setProperty() - get/set property

    If you need to inject() or get() an instance from another class, just tag it with KoinComponent interface.
     */

    /** LifecycleScope */
    /*
    Koin gives the lifecycleScope property already bound to your Android component lifecycle.
    On lifecycle’s end (ON_DESTROY), it will close automatically.

    To benefit from the lifecycleScope, you have to declare a scope for your activity (tied our Activity type):
     */

    scope<AndroidActivity> {
        scoped<PlanetsRepository> { PlanetRepositoryImpl() }
    }

    /** ViewModel */
    /*
    with koin there is no need to use any additional factories for android ViewModel
    you can simply provide & inject it
     */
    factory<FoodRepository> { FoodRepositoryImpl() }

    viewModel { AndroidViewModel(get()) }
}