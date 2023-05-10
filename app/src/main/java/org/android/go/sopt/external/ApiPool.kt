package org.android.go.sopt.external

import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

object ApiPool {
    val signUpService: SignUpService =
        PreparedRetrofit.apiServerRetrofitForAnonymous.create(SignUpService::class.java)
    val signInService: SignInService =
        PreparedRetrofit.apiServerRetrofitForAnonymous.create(SignInService::class.java)
}

interface SignUpService {
    @POST("/sign-up")
    fun signUp(
        @Body request: Request
    ): Call<Response>

    @Serializable
    data class Request(
        val id: String,
        val password: String,
        val name: String,
        val skill: String?
    )

    @Serializable
    data class Response(
        val status: Int,
        val message: String,
        val data: Data?,
    ) {

        @Serializable
        data class Data(
            val name: String,
            val skill: String?
        )
    }
}

interface SignInService {
    @POST("/sign-in")
    fun signIn(
        @Body request: Request
    ): Call<Response>

    @Serializable
    data class Request(
        val id: String,
        val password: String
    )

    @Serializable
    data class Response(
        val status: Int,
        val message: String,
        val data: Data?,
    ) {

        @Serializable
        data class Data(
            val id: String,
            val name: String,
            val skill: String?
        )
    }
}