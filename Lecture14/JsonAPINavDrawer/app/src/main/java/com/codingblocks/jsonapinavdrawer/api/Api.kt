package com.codingblocks.jsonapinavdrawer.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object api {
    private val r = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val jp = r.create(JsonPlaceholder::class.java)
}