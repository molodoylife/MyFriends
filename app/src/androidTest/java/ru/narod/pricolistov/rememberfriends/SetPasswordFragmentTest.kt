package ru.narod.pricolistov.rememberfriends

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import ru.narod.pricolistov.rememberfriends.presentation.set_password.SetPasswordFragment

@RunWith(AndroidJUnit4::class)
@MediumTest
class SetPasswordFragmentTest {

    @Test
    fun testOpenMainPageFromSetPasswordFragment(){

        // GIVEN - On the home screen
        val scenario = launchFragmentInContainer<SetPasswordFragment>(Bundle(), R.style.AppTheme)
        val navController = mock(NavController::class.java)
        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        // WHEN - Click on the "+" button
        onView(withId(R.id.tvSetPasswordLater)).perform(ViewActions.click())

        // THEN - Verify that we navigate to the add screen
        verify(navController).navigate(R.id.action_setNewPassword_to_mainPageFragment)
    }
}