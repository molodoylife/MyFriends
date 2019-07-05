package ru.narod.pricolistov.rememberfriends

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import java.util.*


val randomModule = Kodein.Module("random") {
    bind() from provider { Random() }
}