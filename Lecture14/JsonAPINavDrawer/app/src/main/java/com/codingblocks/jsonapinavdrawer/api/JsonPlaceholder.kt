package com.codingblocks.jsonapinavdrawer.api

import com.codingblocks.jsonapinavdrawer.models.Album
import com.codingblocks.jsonapinavdrawer.models.Post
import com.codingblocks.jsonapinavdrawer.models.Todo
import com.codingblocks.jsonapinavdrawer.models.User
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholder {

    @GET("/users") fun getUsers (): Call<ArrayList<User>>
    @GET("/posts") fun getPosts (): Call<ArrayList<Post>>
    @GET("/albums") fun getAlbums (): Call<ArrayList<Album>>
    @GET("/todos") fun getTodos (): Call<ArrayList<Todo>>

}