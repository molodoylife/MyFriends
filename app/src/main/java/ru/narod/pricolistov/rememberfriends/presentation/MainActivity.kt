package ru.narod.pricolistov.rememberfriends.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.retainedKodein
import ru.narod.pricolistov.rememberfriends.R

class MainActivity : AppCompatActivity(), KodeinAware {

    private val parentKodein by lazy { (applicationContext as KodeinAware).kodein }

    override val kodein by retainedKodein {
        extend(parentKodein)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
