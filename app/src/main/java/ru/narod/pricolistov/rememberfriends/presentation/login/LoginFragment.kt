package ru.narod.pricolistov.rememberfriends.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.login_fragment.*
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.on
import org.kodein.di.named
import ru.narod.pricolistov.presentationcomponents.view.BaseFragment
import ru.narod.pricolistov.rememberfriends.R


class LoginFragment : BaseFragment(){
    override val kodein by Kodein.lazy {
        import(loginModule)
    }

    private val loginModel: LoginViewModel by  kodein.on(context = this).instance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()

        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        loginNext.setOnClickListener {
            //loginModel.navigateToMainPage()
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainPageFragment)
        }
    }
}

