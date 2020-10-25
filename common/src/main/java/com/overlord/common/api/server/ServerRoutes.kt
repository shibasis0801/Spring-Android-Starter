package com.overlord.common.api.server

import com.overlord.common.core.Networking
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


// Have to figure out how to store API routes

object DiagnosticsAPIConfig {
    const val BASE = "/diagnostics"
    object Routes {
        const val HELLO = "$BASE/hello-world"
    }
}

interface DiagnosticsAPIContract {
    @GET(DiagnosticsAPIConfig.Routes.HELLO)
    suspend fun helloWorld(): String
}

val DiagnosticsAPI: DiagnosticsAPIContract by lazy {
    Retrofit.Builder()
        .baseUrl("http://localhost:8080")
        .client(Networking.http)
        .addConverterFactory(MoshiConverterFactory.create(Networking.moshi))
        .build()
        .create(DiagnosticsAPIContract::class.java)
}
