package com.overlord.common

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Networking {
    lateinit var baseURL: String

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val http = OkHttpClient.Builder()
        .build()

    fun initialise(baseURL: String) {
        Networking.baseURL = baseURL
    }
}

fun getRetrofit(endpointBase: String) =
    Retrofit.Builder()
        .baseUrl("${Networking.baseURL}/${endpointBase}/")
        .client(Networking.http)
        .addConverterFactory(MoshiConverterFactory.create(Networking.moshi))
        .build()


/*
WebSocket implementation Idea

Single websocket using OkHTTP and Moshi.
Use Kotlin Channels and Flow to create something bidirectional.
Use UUID.randomUUID to generate deviceIDs before sending to server. (put in DataStore)
Have an OkHTTP interceptor which will send deviceID with every request.

Will have a small serialization framework for sending commands to/from
Implement a basic group chat application using this.

*/


