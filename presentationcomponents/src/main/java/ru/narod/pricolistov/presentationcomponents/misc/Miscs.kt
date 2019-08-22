package ru.narod.pricolistov.presentationcomponents.misc

import android.content.Intent


inline fun <reified T : Enum<T>> Intent.putExtra(victim: T): Intent =
    putExtra(T::class.qualifiedName, victim.ordinal)

inline fun <reified T: Enum<T>> Intent.getEnumExtra(): T? =
    getIntExtra(T::class.qualifiedName, -1)
        .takeUnless { it == -1 }
        ?.let { T::class.java.enumConstants[it] }
