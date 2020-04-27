package di.playground.koin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.PlanetsRepository
import di.playground.core.data.StringHolder
import di.playground.koin.R
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class AndroidActivity : AppCompatActivity() {

    private val stringHolder by inject<StringHolder>()
    private val planetsRepository: PlanetsRepository by lifecycleScope.inject()

    private val vm: AndroidViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android)

        Timber.e("-------------------")

        Timber.e("string from StringHolder: ${stringHolder.string}")

        // not retains between activity recreations
        // On lifecycle’s end (ON_DESTROY), it will close automatically.
        Timber.e("planet: ${planetsRepository.getPlanet()}")

        vm.print()
    }
}
