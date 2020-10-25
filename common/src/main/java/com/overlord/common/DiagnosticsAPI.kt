package com.overlord.common

import retrofit2.http.GET

// Need to have a better approach
object DiagnosticsRoute {
    object Config {
        const val BASE = "diagnostics"
        const val HELLO = "hello-world"
    }

    interface Contract {
        @GET(Config.HELLO)
        suspend fun helloWorld(): Hello
    }
}

val DiagnosticsAPI by lazy {
    getRetrofit(DiagnosticsRoute.Config.BASE).create(DiagnosticsRoute.Contract::class.java)
}

data class Hello(val text: String)