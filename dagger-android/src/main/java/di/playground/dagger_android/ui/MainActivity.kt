package di.playground.dagger_android.ui

import android.os.Bundle
import dagger.android.AndroidInjection
import di.playground.core.BaseActivity
import di.playground.dagger_android.R
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>(R.layout.activity_main) {

    @Inject
    override lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}
