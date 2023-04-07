package org.android.go.sopt.internal.signup

data class SignUpUser(
    val id: String,
    private val password: String,
    val name: String?,
    val hobby: String?
): java.io.Serializable
