package com.example.damn_rca_examen_02.service

import com.example.damn_rca_examen_02.entities.Comment
import com.example.damn_rca_examen_02.entities.Post
import com.example.damn_rca_examen_02.entities.User
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("posts")
    suspend fun getPosts(@Query("userId") userId: Int): List<Post>

    @GET("comments")
    suspend fun getComments(@Query("postId") postId: Int): List<Comment>
}