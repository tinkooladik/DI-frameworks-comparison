package di.playground.kodein.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.Settings
import di.playground.kodein.App
import di.playground.kodein.R
import di.playground.kodein.di.SettingsEntries
import org.kodein.di.generic.instance
import timber.log.Timber

class MultibindingActivity : AppCompatActivity() {

    val settingsSet: Set<Settings> by App.kodein.instance()
    val setForMap: SettingsEntries by App.kodein.instance() //¯\_(ツ)_/¯

    val settingsMap: Map<String, Settings>
        get() = setForMap.toMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multibinding)

        Timber.e("-------------------")

        Timber.e("set: ${settingsSet.map { it.log() }}")
        Timber.e("map: ${settingsMap.mapValues { it.value.log() }}")
    }
}
