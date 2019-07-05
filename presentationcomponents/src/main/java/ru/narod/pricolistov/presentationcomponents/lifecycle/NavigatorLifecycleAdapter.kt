package ru.narod.pricolistov.presentationcomponents.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import ru.narod.pricolistov.presentationcomponents.navigation.Navigator

class NavigatorLifecycleAdapter<Component : Any>(private val navigator: Navigator<Component>) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    internal fun dispatchOnAttach(component: Component) {
        navigator.onAttach(component)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    internal fun dispatchOnDetach() {
        navigator.onDetach()
    }
}