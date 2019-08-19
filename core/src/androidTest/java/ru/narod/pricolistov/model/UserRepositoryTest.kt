package ru.narod.pricolistov.model


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.runner.RunWith
import ru.narod.pricolistov.infrastructure.user.repo.UserRepositoryImp

@RunWith(AndroidJUnit4::class)
class UserRepositoryTest {
    @Test
    fun isStroreFirstSessionCorrect() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val userRepo = UserRepositoryImp(appContext)

        userRepo.storeIfFirstSession()

        assertFalse(userRepo.getIfFirstSession())
    }
}