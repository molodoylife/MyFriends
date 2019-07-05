package ru.narod.pricolistov.presentationcomponents.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import ru.narod.pricolistov.presentationcomponents.lifecycle.LifecycleDispatcher

open class BaseFragment: Fragment(), KodeinAware {
    override val kodein by closestKodein()

    private val lifecycleDispatcher: LifecycleDispatcher by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleDispatcher.attachTo(lifecycle)
    }
}