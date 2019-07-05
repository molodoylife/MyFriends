package ru.narod.pricolistov.presentationcomponents.misc

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

operator fun Lifecycle.plusAssign(o: LifecycleObserver) = addObserver(o)
operator fun Lifecycle.minusAssign(o: LifecycleObserver) = removeObserver(o)