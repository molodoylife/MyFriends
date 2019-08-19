package ru.narod.pricolistov.rememberfriends.presentation.add_contact

import androidx.navigation.fragment.findNavController
import ru.narod.pricolistov.presentationcomponents.view.BaseFragment


abstract class AddContactNavigator {
    abstract fun navigateUp(): Boolean
}

class AddContactNavigatorImp(private val fragment: BaseFragment): AddContactNavigator() {
    override fun navigateUp() = fragment.findNavController().navigateUp()
}