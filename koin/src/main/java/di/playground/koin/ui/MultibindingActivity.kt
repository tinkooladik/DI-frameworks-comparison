package di.playground.koin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.Settings
import di.playground.koin.KoinApp.Companion.koin
import di.playground.koin.R
import timber.log.Timber

class MultibindingActivity : AppCompatActivity() {

    private val settingsSet = koin.getAll<Settings>().toSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multibinding)

        Timber.e("set: ${settingsSet.map { it.log() }}")
    }
}
