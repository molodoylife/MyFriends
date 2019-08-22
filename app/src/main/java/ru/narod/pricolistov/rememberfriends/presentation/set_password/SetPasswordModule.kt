package ru.narod.pricolistov.rememberfriends.presentation.set_password

import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import ru.narod.pricolistov.infrastructure.user.repo.UserRepository
import ru.narod.pricolistov.infrastructure.user.repo.UserRepositoryImp
import ru.narod.pricolistov.presentationcomponents.misc.fragmentScope
import ru.narod.pricolistov.presentationcomponents.view.BaseFragment

fun setPasswordModule(fragment: BaseFragment) = Kodein.Module("setPassword") {
    bind<SetPasswordNavigator>() with singleton { SetPasswordNavigatorImp(fragment) }
    bind<UserRepository>() with singleton { UserRepositoryImp(fragment.context!!) }

    bind<SetPasswordViewModel>() with scoped(fragment.fragmentScope).singleton {
        ViewModelProviders.of(fragment, SetPasswordViewModelImp.FACTORY(instance(), instance()))
            .get(SetPasswordViewModelImp::class.java)
    }
}
