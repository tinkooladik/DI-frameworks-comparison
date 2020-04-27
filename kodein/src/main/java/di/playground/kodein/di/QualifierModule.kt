package di.playground.kodein.di

import di.playground.core.data.FoodRepository
import di.playground.core.data.FoodRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton


/**
 * Qualifier
 */

val qualifierModule = Kodein.Module("qualifier") {

    bind<FoodRepository>(tag = "food") with singleton { FoodRepositoryImpl() }
    bind<FoodRepository>(tag = "food1") with singleton { FoodRepositoryImpl() }
}
