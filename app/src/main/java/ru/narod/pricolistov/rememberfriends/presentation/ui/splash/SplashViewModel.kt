package ru.narod.pricolistov.rememberfriends.presentation.ui.splash

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModel
import ru.narod.pricolistov.core.session.model.entity.Session
import ru.narod.pricolistov.infrastructure.user.repo.UserRepository
import ru.narod.pricolistov.presentationcomponents.misc.putExtra
import ru.narod.pricolistov.presentationcomponents.misc.singleArgViewModelFactory
import ru.narod.pricolistov.rememberfriends.presentation.ui.MainActivity

abstract class SplashViewModel : ViewModel() {
    abstract suspend fun getCurrentUserSession(): Session

    abstract fun navigateToMainActivity(context: Activity, session: Session)
}

class SplashViewModelImp(private val repository: UserRepository): SplashViewModel(){
    companion object {
        val FACTORY = singleArgViewModelFactory(::SplashViewModelImp)
    }

    override suspend fun getCurrentUserSession(): Session {
        return repository.getCurrentUserSession()
    }

    override fun navigateToMainActivity(context: Activity, session: Session) {
        val intent = Intent(context, MainActivity::class.java).apply {
            putExtra(session)
        }

        context.startActivity(intent)
        context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        context.finish()
    }
}