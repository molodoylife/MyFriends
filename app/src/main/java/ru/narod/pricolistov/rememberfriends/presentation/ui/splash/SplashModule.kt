package ru.narod.pricolistov.rememberfriends.presentation.ui.splash

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein.Module
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import ru.narod.pricolistov.infrastructure.user.repo.UserRepository
import ru.narod.pricolistov.infrastructure.user.repo.UserRepositoryImp

fun splashModule(activity: FragmentActivity) = Module("splash") {
    bind<UserRepository>() with scoped(ActivityRetainedScope).singleton {
        UserRepositoryImp(context.applicationContext)
    }

    bind<SplashViewModel>() with scoped(ActivityRetainedScope).singleton {
        ViewModelProviders.of(activity, SplashViewModelImp.FACTORY(instance())).get(SplashViewModelImp::class.java)
    }
}
