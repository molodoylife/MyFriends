package ru.narod.pricolistov.rememberfriends.presentation.login

import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.narod.pricolistov.presentationcomponents.lifecycle.LifecycleDispatcher
import ru.narod.pricolistov.presentationcomponents.lifecycle.NavigatorLifecycleAdapter
import javax.inject.Provider

val loginModule = Kodein.Module("login") {
    bind<LoginNavigator>() with singleton { LoginNavigatorImp() }
    bind<LifecycleDispatcher>() with provider { LifecycleDispatcherProvider(instance()).get() }

    bind<LoginViewModel>() with provider {
        ViewModelProviders.of(kodein.kodeinContext.value as LoginFragment, LoginViewModelImp.FACTORY(instance())).get(LoginViewModelImp::class.java)
    }
}

class LifecycleDispatcherProvider (private val navigator: LoginNavigator) : Provider<LifecycleDispatcher> {
    override fun get() = LifecycleDispatcher(NavigatorLifecycleAdapter(navigator))
}