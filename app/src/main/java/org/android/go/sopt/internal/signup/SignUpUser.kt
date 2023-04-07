package org.android.go.sopt.internal.signup

data class SignUpUser(
    private val id: String,
    private val password: String,
    private val name: String?,
    private val hobby: String?
)
