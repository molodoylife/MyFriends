package ru.narod.pricolistov.rememberfriends.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.login_fragment.*
import ru.narod.pricolistov.rememberfriends.R

class LoginFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.login_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginNext.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainPageFragment)
        }
    }
}