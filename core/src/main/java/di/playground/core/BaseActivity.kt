package di.playground.core

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : BaseViewModel>(layoutId: Int) : AppCompatActivity(layoutId) {

    abstract val viewModel: T

    override fun onStart() {
        super.onStart()
        viewModel.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.stop()
    }
}