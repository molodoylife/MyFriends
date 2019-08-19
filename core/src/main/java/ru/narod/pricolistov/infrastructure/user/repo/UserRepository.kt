package ru.narod.pricolistov.infrastructure.user.repo

import android.content.Context
import android.content.SharedPreferences

interface UserRepository {
    fun storeIfFirstSession()

    fun getIfFirstSession(): Boolean
}

class UserRepositoryImp(private val context: Context): UserRepository {
    private companion object {
        const val PREFS_NAME = "presentation.repository"
        const val KEY_FIRST_SESSION = "session.first"
    }

    private val prefs: SharedPreferences by lazy(LazyThreadSafetyMode.NONE) { context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }

    override fun storeIfFirstSession() {
        prefs.edit().putBoolean(KEY_FIRST_SESSION, false).apply()
    }

    override fun getIfFirstSession(): Boolean {
        return prefs.getBoolean(KEY_FIRST_SESSION, true)
    }
}