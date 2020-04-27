package di.playground.kodein.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.PlanetsRepository
import di.playground.kodein.App
import di.playground.kodein.R
import org.kodein.di.KodeinTrigger
import org.kodein.di.generic.instance
import timber.log.Timber

class AndroidActivity : AppCompatActivity() {

    private val kodeinTrigger = KodeinTrigger()
    private val pkgName: String by App.kodein.instance<String>("packageName")
    private val planetsRepository: PlanetsRepository by App.kodein.instance<PlanetsRepository>()

    private val vm: MyAndroidViewModel by App.kodein.instance<MyAndroidViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android)

        Timber.e("-------------------")

        // The kodein AND all dependencies will both be retrieved at that time.
        kodeinTrigger.trigger()

        Timber.e("pkgName: $pkgName")

        // it retains between activity recreations
        // to check that, you can open this activity, then rotate the screen,
        // then go back and finally open this activity again
        Timber.e("planet: ${planetsRepository.getPlanet()}")

        vm.print()
    }
}
