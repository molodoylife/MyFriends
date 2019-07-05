package ru.narod.pricolistov.rememberfriends.presentation.add_contact

import ru.narod.pricolistov.presentationcomponents.misc.navController
import ru.narod.pricolistov.presentationcomponents.navigation.Navigator
import ru.narod.pricolistov.rememberfriends.R

abstract class AddContactNavigator : Navigator<AddContactFragment>() {
    abstract fun navigateUp()
}

class AddContactNavigatorImp: AddContactNavigator() {
    override fun navigateUp() = runOrEnqueue {
        it.navController(R.id.addContactFragment).navigateUp()
    }
}