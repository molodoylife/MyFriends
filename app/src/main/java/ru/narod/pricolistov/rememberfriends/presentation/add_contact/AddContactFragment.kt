package ru.narod.pricolistov.rememberfriends.presentation.add_contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.add_contact.*
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import ru.narod.pricolistov.presentationcomponents.view.BaseFragment
import ru.narod.pricolistov.rememberfriends.R
import ru.narod.pricolistov.rememberfriends.presentation.login.loginModule
import java.util.*

class AddContactFragment : BaseFragment(){

    override val kodein by Kodein.lazy {
        //import(loginModule())
    }

    private val random: Random by instance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        addContact.setOnClickListener {
//            Navigation.findNavController(view).popBackStack()
//        }
//
//        Toast.makeText(activity, "${random.nextInt()}", Toast.LENGTH_SHORT).show()
    }
}