package ru.narod.pricolistov.rememberfriends.presentation.ui.splash

import androidx.lifecycle.ViewModel
import ru.narod.pricolistov.core.session.model.entity.Session
import ru.narod.pricolistov.infrastructure.user.repo.UserRepository
import ru.narod.pricolistov.presentationcomponents.misc.singleArgViewModelFactory

abstract class SplashViewModel : ViewModel() {

    abstract suspend fun getCurrentUserSession(): Session
}

class SplashViewModelImp(private val repository: UserRepository): SplashViewModel(){
    companion object {
        val FACTORY = singleArgViewModelFactory(::SplashViewModelImp)
    }

    override suspend fun getCurrentUserSession(): Session {
        return repository.getCurrentUserSession()
    }
}