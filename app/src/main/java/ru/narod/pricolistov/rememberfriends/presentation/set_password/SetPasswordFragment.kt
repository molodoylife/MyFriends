package ru.narod.pricolistov.rememberfriends.presentation.set_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.set_password_fragment.*
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import ru.narod.pricolistov.presentationcomponents.view.BaseFragment
import ru.narod.pricolistov.rememberfriends.R

class SetPasswordFragment : BaseFragment(){
    override val kodein by Kodein.lazy {
        import(setPasswordModule(this@SetPasswordFragment))
    }

    private val viewModel: SetPasswordViewModel by instance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()

        return inflater.inflate(R.layout.set_password_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tvSetPasswordLater.setOnClickListener {
            viewModel.navigateToMainPage()
        }

        btnSaveSetNewPassword.setOnClickListener {
            //viewModel.setNewPassword()
        }
    }
}