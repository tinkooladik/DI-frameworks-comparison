package di.playground.koin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.FoodRepository
import di.playground.koin.R
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import timber.log.Timber

class QualifierActivity : AppCompatActivity() {

    private val food by inject<FoodRepository>(named("food"))
    private val food1 by inject<FoodRepository>(named("food1"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qualifier)

        Timber.e("-------------------")

        Timber.e("food: ${food.getFood()}")
        Timber.e("food1: ${food1.getFood()}")
    }
}
