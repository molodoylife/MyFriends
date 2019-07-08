package ru.narod.pricolistov.rememberfriends.presentation.set_password

import androidx.lifecycle.ViewModel
import ru.narod.pricolistov.presentationcomponents.misc.singleArgViewModelFactory

abstract class SetPasswordViewModel : ViewModel(){

    abstract fun navigateUp()

    abstract fun navigateToMainPage()

}

class SetPasswordViewModelImp(private val navigator: SetPasswordNavigator): SetPasswordViewModel(){
    companion object {
        val FACTORY = singleArgViewModelFactory(::SetPasswordViewModelImp)
    }

    override fun navigateUp() {
        navigator.navigateUp()
    }

    override fun navigateToMainPage() {
        navigator.navigateToMainPage()
    }
}