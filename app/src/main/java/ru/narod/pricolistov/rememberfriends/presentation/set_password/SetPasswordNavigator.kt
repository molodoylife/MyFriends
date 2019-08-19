package ru.narod.pricolistov.rememberfriends.presentation.set_password

import androidx.navigation.fragment.findNavController
import ru.narod.pricolistov.presentationcomponents.view.BaseFragment
import ru.narod.pricolistov.rememberfriends.R

abstract class SetPasswordNavigator {
    abstract fun navigateUp(): Boolean

    abstract fun navigateToMainPage()
}

class SetPasswordNavigatorImp(private val fragment: BaseFragment) : SetPasswordNavigator() {
    override fun navigateUp() = fragment.findNavController().navigateUp()

    override fun navigateToMainPage() = fragment.findNavController().navigate(
        R.id.action_setNewPassword_to_mainPageFragment)
}