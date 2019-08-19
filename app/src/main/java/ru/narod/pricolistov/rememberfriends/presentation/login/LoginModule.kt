package ru.narod.pricolistov.rememberfriends.presentation.login

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.generic.*
import ru.narod.pricolistov.presentationcomponents.lifecycle.LifecycleDispatcher
import ru.narod.pricolistov.presentationcomponents.lifecycle.NavigatorLifecycleAdapter
import javax.inject.Provider

fun loginModule(fragment: Fragment) = Kodein.Module("login") {
    bind<LoginNavigator>() with singleton { LoginNavigatorImp() }
    bind<LifecycleDispatcher>() with provider { LifecycleDispatcherProvider(instance()).get() }

    bind<LoginViewModel>(tag = "loginModel") with scoped(ActivityRetainedScope).singleton {
        ViewModelProviders.of(fragment, LoginViewModelImp.FACTORY(instance())).get(LoginViewModelImp::class.java)
    }
}

class LifecycleDispatcherProvider (private val navigator: LoginNavigator) : Provider<LifecycleDispatcher> {
    override fun get() = LifecycleDispatcher(NavigatorLifecycleAdapter(navigator))
}