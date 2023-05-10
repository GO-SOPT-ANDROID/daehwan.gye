package org.android.go.sopt.external

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object PreparedRetrofit {
    val apiServerRetrofitForAnonymous by lazy {
        Retrofit.Builder()
            .baseUrl("http://52.78.152.187:8080")
            .client(
                OkHttpClient.Builder().apply {
                    connectTimeout(10, TimeUnit.SECONDS)
                    writeTimeout(5, TimeUnit.SECONDS)
                    readTimeout(5, TimeUnit.SECONDS)
                }.build()
            )
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}