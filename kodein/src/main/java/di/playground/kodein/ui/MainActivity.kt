package di.playground.kodein.ui

import android.os.Bundle
import di.playground.core.BaseActivity
import di.playground.kodein.App
import di.playground.kodein.R
import org.kodein.di.generic.instance

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by App.kodein.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}