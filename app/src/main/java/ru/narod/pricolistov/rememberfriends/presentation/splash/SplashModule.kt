package ru.narod.pricolistov.rememberfriends.presentation.splash

import org.kodein.di.Kodein
import org.kodein.di.android.ActivityRetainedScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import ru.narod.pricolistov.infrastructure.user.repo.UserRepository
import ru.narod.pricolistov.infrastructure.user.repo.UserRepositoryImp

val splashModule = Kodein.Module("splash") {
    bind<UserRepository>() with scoped(ActivityRetainedScope).singleton {
        UserRepositoryImp(
            context
        )
    }
}
