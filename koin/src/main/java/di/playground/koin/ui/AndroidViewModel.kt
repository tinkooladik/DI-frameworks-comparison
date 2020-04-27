package di.playground.koin.ui

import androidx.lifecycle.ViewModel
import di.playground.core.data.FoodRepository
import timber.log.Timber

class AndroidViewModel(private val foodRepository: FoodRepository) : ViewModel() {

    fun print() {
        Timber.e("vm food: ${foodRepository.getFood()}")
    }

}