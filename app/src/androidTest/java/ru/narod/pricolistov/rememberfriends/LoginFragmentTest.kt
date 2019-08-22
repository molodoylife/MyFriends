package ru.narod.pricolistov.rememberfriends

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify
import ru.narod.pricolistov.rememberfriends.presentation.login.LoginFragment

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com
 * /tools/testing).
 */

@RunWith(AndroidJUnit4::class)
@MediumTest
class LoginFragmentTest {

    @Test
    fun testOpenMainPageFromLoginFragment(){

        // GIVEN - On the home screen
        val scenario = launchFragmentInContainer<LoginFragment>(Bundle(), R.style.AppTheme)
        val navController = Mockito.mock(NavController::class.java)
        scenario.onFragment {
            Navigation.setViewNavController(it.view!!, navController)
        }

        // WHEN - Click on the "+" button
        onView(ViewMatchers.withId(R.id.loginNext)).perform(ViewActions.click())

        // THEN - Verify that we navigate to the add screen
        verify(navController).navigate(R.id.action_loginFragment_to_mainPageFragment)
    }
}
