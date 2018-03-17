package com.codingblocks.consumerestapi.api

import com.codingblocks.consumerestapi.models.Post
import com.codingblocks.consumerestapi.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JpApi {
    @GET("/users")
    fun getUsers (): Call<Array<User>>
    @GET("/users/{userId}")
    fun getUserById(
            @Path("userId") userId: Int
    ): Call<User>



    @GET("/posts")
    fun getPosts(): Call<Array<Post>>
}