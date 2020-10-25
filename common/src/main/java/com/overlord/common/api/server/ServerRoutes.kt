package com.overlord.common.api.server

import com.overlord.common.core.Networking
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


// Have to figure out how to store API routes

object DiagnosticsAPIConfig {
    const val BASE = "/diagnostics"
    object Routes {
        const val HELLO = "/hello-world"
    }
}

data class Hello(val text: String)

interface DiagnosticsAPIContract {
    @GET("hello-world")
    suspend fun helloWorld(): Hello
}


fun getDiagnosticsAPI(baseURL: String) = Retrofit.Builder()
        .baseUrl(baseURL + DiagnosticsAPIConfig.BASE + "/")
        .client(Networking.http)
        .addConverterFactory(MoshiConverterFactory.create(Networking.moshi))
        .build()
        .create(DiagnosticsAPIContract::class.java)
