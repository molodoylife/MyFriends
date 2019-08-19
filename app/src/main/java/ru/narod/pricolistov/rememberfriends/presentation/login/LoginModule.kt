package ru.narod.pricolistov.rememberfriends.presentation.login

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.Kodein.Module
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

fun loginModule(fragment: LoginFragment) = Module("login") {
    bind<LoginNavigator>() with singleton { LoginNavigatorImp(fragment) }

    bind<LoginViewModel>() with scoped(ActivityRetainedScope).singleton {
        ViewModelProviders.of(fragment, LoginViewModelImp.FACTORY(instance())).get(LoginViewModelImp::class.java)
    }
}
