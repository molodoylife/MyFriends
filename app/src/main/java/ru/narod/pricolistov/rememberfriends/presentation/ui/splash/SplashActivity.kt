package ru.narod.pricolistov.rememberfriends.presentation.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.runBlocking
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.LazyKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.on
import ru.narod.pricolistov.infrastructure.user.repo.UserRepository

class SplashActivity : AppCompatActivity(), KodeinAware {

    override val kodein by LazyKodein {
        Kodein {
            import(splashModule(this@SplashActivity))
        }
    }

    private val userRepository: UserRepository by kodein.on(context = this).instance()
    private val splashViewModel: SplashViewModel by kodein.on(context = this).instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val session = runBlocking {
            Thread.sleep(2000)
            userRepository.getCurrentUserSession()
        }

        splashViewModel.navigateToMainActivity(this, session)
    }
}