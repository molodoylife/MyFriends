package ru.narod.pricolistov.rememberfriends.presentation.login

import androidx.navigation.fragment.findNavController
import ru.narod.pricolistov.presentationcomponents.view.BaseFragment
import ru.narod.pricolistov.rememberfriends.R

abstract class LoginNavigator {
    abstract fun navigateUp(): Boolean

    abstract fun navigateToMainPage()
}

class LoginNavigatorImp(private val fragment: BaseFragment) : LoginNavigator() {
    override fun navigateUp() = fragment.findNavController().navigateUp()

    override fun navigateToMainPage() =  fragment.findNavController().navigate(
        R.id.action_loginFragment_to_mainPageFragment)
}