package di.playground.kodein.di

import di.playground.core.data.AnimalRepository
import di.playground.core.data.AnimalRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.bindings.StandardScopeRegistry
import org.kodein.di.bindings.WeakContextScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton


/**
 * SCOPES
 */

object TestContext
object AnotherTestContext
object TestScope : WeakContextScope<TestContext>({ StandardScopeRegistry() })
object AnotherTestScope : WeakContextScope<AnotherTestContext>({ StandardScopeRegistry() })

val scopeModule = Kodein.Module("scope") {

    /* No scope, not singleton */
    bind<AnimalRepository>() with provider { AnimalRepositoryImpl() }

    /* Simple scope */
    bind<AnimalRepository>() with scoped(TestScope).singleton { AnimalRepositoryImpl() }
    bind<AnimalRepository>() with scoped(AnotherTestScope).singleton { AnimalRepositoryImpl() }

    /* Scope closeable
     * If a value implements ScopeCloseable, it’s close function will be called when the value is removed from the scope
     * (or when the scope itself expires).
     * Not all scopes support this feature.
     */
}