package com.overlord.common.core

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object Networking {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val http = OkHttpClient.Builder()
        .build()
}