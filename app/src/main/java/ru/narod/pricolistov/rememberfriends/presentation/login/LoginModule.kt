package ru.narod.pricolistov.rememberfriends.presentation.login

import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import ru.narod.pricolistov.presentationcomponents.misc.fragmentScope

fun loginModule(fragment: LoginFragment) = Module("login") {
    bind<LoginNavigator>() with singleton { LoginNavigatorImp(fragment) }

    bind<LoginViewModel>() with scoped(fragment.fragmentScope).singleton {
        ViewModelProviders.of(fragment, LoginViewModelImp.FACTORY(instance())).get(LoginViewModelImp::class.java)
    }
}
