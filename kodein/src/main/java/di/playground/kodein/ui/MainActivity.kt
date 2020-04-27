package di.playground.kodein.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import di.playground.core.data.UserRepository
import di.playground.kodein.App
import di.playground.kodein.R
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.generic.instance
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val userRepository: UserRepository by App.kodein.instance<UserRepository>()

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