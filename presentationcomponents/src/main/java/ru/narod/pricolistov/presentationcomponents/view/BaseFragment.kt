package ru.narod.pricolistov.presentationcomponents.view

import androidx.fragment.app.Fragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

open class BaseFragment: Fragment(), KodeinAware {
    override val kodein by closestKodein()
}