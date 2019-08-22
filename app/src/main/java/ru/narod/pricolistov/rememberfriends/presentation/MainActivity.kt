package ru.narod.pricolistov.rememberfriends.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.retainedKodein
import ru.narod.pricolistov.rememberfriends.R
import ru.narod.pricolistov.rememberfriends.presentation.splash.SplashActivity.Companion.EXTRA_FIRST_TIME

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

        val isFirstTime = intent.getBooleanExtra(EXTRA_FIRST_TIME, true)
        if (!isFirstTime) {
            graph.startDestination = R.id.loginFragment
        } else {
            graph.startDestination = R.id.setNewPassword
        }

        navHostFragment.navController.graph = graph
    }

}
