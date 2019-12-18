package di.playground.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.UserRepository
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.component.inject(this)

        Timber.e(userRepository.fetchUsers().toString())
    }
}