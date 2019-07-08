package ru.narod.pricolistov.rememberfriends.presentation.set_password

import ru.narod.pricolistov.presentationcomponents.misc.navController
import ru.narod.pricolistov.presentationcomponents.navigation.Navigator
import ru.narod.pricolistov.rememberfriends.R

abstract class SetPasswordNavigator : Navigator<SetPasswordFragment>() {
    abstract fun navigateUp()

    abstract fun navigateToMainPage()
}

class SetPasswordNavigatorImp : SetPasswordNavigator() {
    override fun navigateUp() = runOrEnqueue {
        it.navController().navigateUp()
    }

    override fun navigateToMainPage() = runOrEnqueue {
        it.navController().navigate(
            R.id.action_setNewPassword_to_mainPageFragment)
    }
}