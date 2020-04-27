package di.playground.kodein.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.FoodRepository
import di.playground.kodein.App
import di.playground.kodein.R
import org.kodein.di.generic.instance
import timber.log.Timber

class QualifierActivity : AppCompatActivity() {

    private val food by App.kodein.instance<FoodRepository>("food")
    private val food1 by App.kodein.instance<FoodRepository>("food1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qualifier)

        Timber.e("-------------------")

        Timber.e("food: ${food.getFood()}")
        Timber.e("food1: ${food1.getFood()}")
    }
}
