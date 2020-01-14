package di.playground.kodein.ui

import di.playground.core.BaseViewModel
import di.playground.core.data.UserRepository
import timber.log.Timber

class MainViewModel(
    private val userRepository: UserRepository
) : BaseViewModel() {

    override fun start() {
        Timber.e(userRepository.fetchUsers().toString())
    }

    override fun stop() {

    }
}