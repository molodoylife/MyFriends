package ru.narod.pricolistov.infrastructure.user.repo

import android.content.Context
import android.content.SharedPreferences
import ru.narod.pricolistov.core.session.model.entity.Session
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

interface UserRepository {
    fun storeIfFirstSession()

    fun storeUserPassword()

    fun getIfFirstSession(): Boolean

    fun getIfUserHasSetPassword(): Boolean

    suspend fun getCurrentUserSession(): Session
}

class UserRepositoryImp(private val context: Context): UserRepository {

    private companion object {
        const val PREFS_NAME = "presentation.repository"
        const val KEY_FIRST_SESSION = "session.first"
        const val KEY_PASSWORD = "session.password"
    }

    private val prefs: SharedPreferences by lazy(LazyThreadSafetyMode.NONE) { context.getSharedPreferences(PREFS_NAME,
        Context.MODE_PRIVATE) }

    override fun storeIfFirstSession() {
        prefs.edit().putBoolean(KEY_FIRST_SESSION, false).apply()
    }

    override fun storeUserPassword() {
        prefs.edit().putString(KEY_PASSWORD, "").apply()
    }

    override fun getIfFirstSession(): Boolean {
        return prefs.getBoolean(KEY_FIRST_SESSION, true)
    }

    override fun getIfUserHasSetPassword(): Boolean {
        return !prefs.getString(KEY_PASSWORD, "").isNullOrEmpty()
    }

    override suspend fun getCurrentUserSession(): Session {

        return suspendCoroutine { continuation ->
            val isFirstEnter = getIfFirstSession()

            val hasPasswordBeenSet = getIfUserHasSetPassword()

            when {
                isFirstEnter -> continuation.resume(Session.FIRST_ENTER)
                hasPasswordBeenSet -> continuation.resume(Session.PASSWORD_EXIST)
                else -> continuation.resume(Session.WILL_SET_PASSWORD_LATER)
            }
        }


    }
}