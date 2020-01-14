package di.playground.dagger.ui

import android.os.Bundle
import di.playground.core.BaseActivity
import di.playground.dagger.App
import di.playground.dagger.R
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    @Inject
    override lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.component.inject(this)
    }
}