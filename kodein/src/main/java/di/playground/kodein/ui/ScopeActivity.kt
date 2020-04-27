package di.playground.kodein.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.AnimalRepository
import di.playground.kodein.App
import di.playground.kodein.R
import di.playground.kodein.di.AnotherTestContext
import di.playground.kodein.di.TestContext
import org.kodein.di.generic.instance
import org.kodein.di.generic.on
import timber.log.Timber

class ScopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope)

        Timber.e("-------------------")

        printAnimal(TestContext)
        printAnimal(AnotherTestContext)

        val repo by App.kodein.instance<AnimalRepository>()
        Timber.e("no scope: ${repo.getAnimal()}")
    }

    private inline fun <reified C> printAnimal(ctx: C) {
        val kodeinWithContext = App.kodein.on(context = ctx)
        val scopedInstance by kodeinWithContext.instance<AnimalRepository>()
        Timber.e("scoped $ctx: ${scopedInstance.getAnimal()}")
    }
}
