package ru.narod.pricolistov.rememberfriends.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.login_fragment.*
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import ru.narod.pricolistov.presentationcomponents.view.BaseFragment
import ru.narod.pricolistov.rememberfriends.R

class LoginFragment : BaseFragment(){

    override val kodein by Kodein.lazy {
        import(loginModule)
    }

    private val navigator: LoginNavigator by instance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginNext.setOnClickListener {
            navigator.navigateToMainPage()
        }
    }
}