package di.playground.kodein.ui

import androidx.lifecycle.ViewModel
import di.playground.core.data.FoodRepository
import timber.log.Timber

class MyAndroidViewModel(private val foodRepository: FoodRepository) : ViewModel() {

    fun print() {
        Timber.e("vm food: ${foodRepository.getFood()}")
    }

}