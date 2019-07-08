package ru.narod.pricolistov.presentationcomponents.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import ru.narod.pricolistov.presentationcomponents.misc.plusAssign

class LifecycleDispatcher(private vararg val observers: LifecycleObserver) {

    fun attachTo(lifecycle: Lifecycle) {
        observers.forEach { lifecycle += it }
    }
}