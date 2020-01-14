package di.playground.dagger_android.ui

import di.playground.core.BaseViewModel
import di.playground.core.data.UserRepository
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private var userRepository: UserRepository
) : BaseViewModel() {

    override fun start() {
        Timber.e(userRepository.fetchUsers().toString())
    }

    override fun stop() {

    }
}