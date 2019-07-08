package ru.narod.pricolistov.presentationcomponents.misc

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.instance

operator fun Lifecycle.plusAssign(o: LifecycleObserver) = addObserver(o)
operator fun Lifecycle.minusAssign(o: LifecycleObserver) = removeObserver(o)
