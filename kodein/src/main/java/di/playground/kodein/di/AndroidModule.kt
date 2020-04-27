package di.playground.kodein.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import di.playground.core.data.FoodRepository
import di.playground.core.data.FoodRepositoryImpl
import di.playground.core.data.PlanetRepositoryImpl
import di.playground.core.data.PlanetsRepository
import di.playground.kodein.ui.MyAndroidViewModel
import org.kodein.di.Kodein
import org.kodein.di.TT
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.direct
import org.kodein.di.generic.*

/**
 * Android specific features
 */

val myAndroidModule = Kodein.Module("android") {

    /* All kodein-framework-* modules provide scopes that are specific to the target framework.
     * Android specific scopes:
     */

    /* # Component scopes
     * Kodein-Android provides a standard scope for any android component:
     * bind<Controller>() with scoped(AndroidComponentsWeakScope<Activity>()).singleton { ControllerImpl(context) }
     * context is of type Activity because we are using the androidScope<Activity>()
     * This scope is NOT compatible with ScopeCloseable
     */

    /* # Activity retained scope
     * Kodein-Android provides the ActivityRetainedScope, which is a scope that allows activity-scoped
     * singletons or multitons that are independent from the activity restart.
     * bind<Controller>() with scoped(ActivityRetainedScope).singleton { ControllerImpl() }
     * This scope IS compatible with ScopeCloseable
     */
    bind<PlanetsRepository>() with scoped(ActivityRetainedScope).singleton { PlanetRepositoryImpl() }

    /* # Lifecycle scope
     * Kodein-Android provides the AndroidLifecycleScope, which is a scope that allows activity-scoped
     * singletons or multitons that are bound to a component lifecycle. It uses Android support Lifecycle,
     * so you need to use Android support’s LifecycleOwner components.
     * bind<Controller>() with scoped(AndroidLifecycleScope<Activity>()).singleton { ControllerImpl(context) }
     * These lifecycles are NOT immune to activity restart due to configuration change.
     * This scope IS compatible with ScopeCloseable
     */

    /** ViewModels */
    bind<FoodRepository>() with provider { FoodRepositoryImpl() }
    bind() from provider { MyAndroidViewModel(instance()) }

    /*
    ABOUT KodeinAware inside ViewModel:
    To use Kodein, you need an Android context. For that, View Models need to implement AndroidViewModel.

    If you want your view models to be independant from Kodein, then you need to inject them
    (meaning passing their dependencies by constructor). To do that, you need to create your own ViewModelProvider.Factory.
    Here is a simple one:
     */
    class KodeinViewModelFactory(val kodein: Kodein) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            kodein.direct.Instance(TT(modelClass))
    }
}