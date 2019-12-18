package di.playground.kodein

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.UserRepository
import org.kodein.di.generic.instance
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val userRepository: UserRepository by App.kodein.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.e(userRepository.fetchUsers().toString())
    }
}
