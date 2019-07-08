package ru.narod.pricolistov.rememberfriends.presentation.login

import androidx.lifecycle.ViewModel
import ru.narod.pricolistov.presentationcomponents.misc.singleArgViewModelFactory

abstract class LoginViewModel : ViewModel(){

    abstract fun navigateUp()

    abstract fun navigateToMainPage()

}

class LoginViewModelImp(private val navigator: LoginNavigator): LoginViewModel(){
    companion object {
        val FACTORY = singleArgViewModelFactory(::LoginViewModelImp)
    }

    override fun navigateUp() {
        navigator.navigateUp()
    }

    override fun navigateToMainPage() {
        navigator.navigateToMainPage()
    }
}