package ru.narod.pricolistov.model.user.vo

data class Password(val password: String) {
    companion object {
        fun isValid(s: String?) = !s.isNullOrBlank()
    }

    init {
        require(isValid(password)) { "Invalid password, was $password" }
    }
}