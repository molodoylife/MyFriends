package ru.narod.pricolistov.rememberfriends.presentation.login

import ru.narod.pricolistov.presentationcomponents.misc.navController
import ru.narod.pricolistov.presentationcomponents.navigation.Navigator
import ru.narod.pricolistov.rememberfriends.R

abstract class LoginNavigator : Navigator<LoginFragment>() {
    abstract fun navigateUp()

    abstract fun navigateToMainPage()
}

class LoginNavigatorImp: LoginNavigator() {
    override fun navigateUp() = runOrEnqueue {
        it.navController(R.id.loginFragment).navigateUp()
    }

    override fun navigateToMainPage() = runOrEnqueue {
        it.navController().navigate(R.id.action_loginFragment_to_mainPageFragment)
    }
}