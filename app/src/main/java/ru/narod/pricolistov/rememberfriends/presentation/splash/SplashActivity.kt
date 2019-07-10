package ru.narod.pricolistov.rememberfriends.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.LazyKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.on
import org.kodein.di.named
import ru.narod.pricolistov.infrastructure.user.repo.UserRepository
import ru.narod.pricolistov.rememberfriends.presentation.MainActivity

class SplashActivity : AppCompatActivity(), KodeinAware {
    override val kodein by LazyKodein {
        Kodein {
            import(splashModule)
        }
    }

    private val userRepository: UserRepository by kodein.on(context = this).instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        val isFirst = userRepository.getIfFirstSession()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}