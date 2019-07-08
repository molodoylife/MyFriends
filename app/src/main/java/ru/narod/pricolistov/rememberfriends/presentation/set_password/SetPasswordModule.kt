package ru.narod.pricolistov.rememberfriends.presentation.set_password

import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.narod.pricolistov.presentationcomponents.lifecycle.LifecycleDispatcher
import ru.narod.pricolistov.presentationcomponents.lifecycle.NavigatorLifecycleAdapter
import javax.inject.Provider

val setPasswordModule = Kodein.Module("setPassword") {
    bind<SetPasswordNavigator>() with singleton { SetPasswordNavigatorImp() }
    bind<LifecycleDispatcher>() with provider { LifecycleDispatcherProvider(instance()).get() }

    bind<SetPasswordViewModel>() with provider {
        ViewModelProviders.of(kodein.kodeinContext.value as SetPasswordFragment, SetPasswordViewModelImp.FACTORY(instance()))
            .get(SetPasswordViewModelImp::class.java)
    }
}

class LifecycleDispatcherProvider (private val navigator: SetPasswordNavigator) : Provider<LifecycleDispatcher> {
    override fun get() = LifecycleDispatcher(NavigatorLifecycleAdapter(navigator))
}