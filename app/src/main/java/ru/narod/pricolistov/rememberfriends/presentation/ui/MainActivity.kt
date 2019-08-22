package ru.narod.pricolistov.rememberfriends.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.retainedKodein
import ru.narod.pricolistov.core.session.model.entity.Session
import ru.narod.pricolistov.presentationcomponents.misc.getEnumExtra
import ru.narod.pricolistov.rememberfriends.R

class MainActivity : AppCompatActivity(), KodeinAware {

    private val parentKodein by lazy { (applicationContext as KodeinAware).kodein }

    override val kodein by retainedKodein {
        extend(parentKodein)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        when(intent.getEnumExtra<Session>()){
            Session.FIRST_ENTER -> graph.startDestination = R.id.setNewPassword
            Session.PASSWORD_EXIST -> graph.startDestination = R.id.loginFragment
            Session.WILL_SET_PASSWORD_LATER -> graph.startDestination = R.id.mainPageFragment
        }

        navHostFragment.navController.graph = graph
    }
}
