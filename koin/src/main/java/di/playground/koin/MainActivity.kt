package di.playground.koin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.UserRepository
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val userRepository by inject<UserRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.e(userRepository.fetchUsers().toString())
    }
}
