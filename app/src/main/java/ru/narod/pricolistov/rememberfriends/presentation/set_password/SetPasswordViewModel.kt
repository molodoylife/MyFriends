package ru.narod.pricolistov.rememberfriends.presentation.set_password

import androidx.lifecycle.ViewModel
import ru.narod.pricolistov.infrastructure.user.repo.UserRepository
import ru.narod.pricolistov.presentationcomponents.misc.doubleArgViewModelFactory

abstract class SetPasswordViewModel : ViewModel(){

    abstract fun navigateUp()

    abstract fun navigateToMainPage()

}

class SetPasswordViewModelImp(private val navigator: SetPasswordNavigator,
                              private val userRepository: UserRepository): SetPasswordViewModel(){
    companion object {
        val FACTORY = doubleArgViewModelFactory(::SetPasswordViewModelImp)
    }

    override fun navigateUp() {
        navigator.navigateUp()
    }

    override fun navigateToMainPage() {
        userRepository.storeIfFirstSession()
        navigator.navigateToMainPage()
    }
}