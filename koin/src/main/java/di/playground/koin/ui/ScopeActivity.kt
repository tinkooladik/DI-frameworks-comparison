package di.playground.koin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.AnimalRepository
import di.playground.koin.KoinApp.Companion.koin
import di.playground.koin.R
import di.playground.koin.di.TestTypeQualifier
import di.playground.koin.di.scopeModule
import kotlinx.android.synthetic.main.activity_scope.*
import org.koin.core.context.unloadKoinModules
import org.koin.core.qualifier.named
import timber.log.Timber

class ScopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope)

        Timber.e("-------------------")

        stringQualifierScope("StringScopeId")
        typeQualifierScope("TypeScopeId")

        stringQualifierScope("StringScopeId2")
        typeQualifierScope("TypeScopeId2")

        btnClean.setOnClickListener {
            // drop module's definitions & instances when you don't need it anymore
            // after that app will crash once ScopeActivity's onCreate runs again:

            // org.koin.core.error.NoBeanDefFoundException: No definition found for
            // 'di.playground.core.data.AnimalRepository' has been found. Check your module definitions.

            unloadKoinModules(scopeModule)
        }


        btnCloseScope.setOnClickListener {
            // Once your scope instance is finished, just closed it with the close() function:
            //  Beware that you can't inject instances anymore from a closed scope.
            val myScopeInstance = koin.getScope("StringScopeId")
            Timber.e("close scope: StringScopeId")
            myScopeInstance.close()

            // note: actually, it closes both StringScopeId and StringScopeId2
        }
    }

    private fun stringQualifierScope(id: String) {
        // create a scope instance of scope "StringQualifierScope"
        val myScopeInstance = koin.getOrCreateScope(id, named("StringQualifierScope"))
        // retrieve instance from scope
        val repo = myScopeInstance.get<AnimalRepository>()

        Timber.e("$id: ${repo.getAnimal()}")


        /** close scope when you don't need it anymore */
        // myScopeInstance.close()
    }

    private fun typeQualifierScope(id: String) {
        // create a scope instance of scope "StringQualifierScope"
        val myScopeInstance = koin.getOrCreateScope(id, named<TestTypeQualifier>())
        // retrieve instance from scope
        val repo = myScopeInstance.get<AnimalRepository>()

        Timber.e("$id: ${repo.getAnimal()}")
    }
}
