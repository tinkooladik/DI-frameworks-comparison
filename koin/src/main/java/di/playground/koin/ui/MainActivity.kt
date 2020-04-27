package di.playground.koin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.UserRepository
import di.playground.koin.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val userRepository by inject<UserRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnScope.setOnClickListener {
            startActivity(Intent(this, ScopeActivity::class.java))
        }

        btnQualifier.setOnClickListener {
            startActivity(Intent(this, QualifierActivity::class.java))
        }

        btnMultibinding.setOnClickListener {
            startActivity(Intent(this, MultibindingActivity::class.java))
        }

        btnAndroid.setOnClickListener {
            startActivity(Intent(this, AndroidActivity::class.java))
        }

        Timber.e(userRepository.fetchUsers().toString())
    }
}
