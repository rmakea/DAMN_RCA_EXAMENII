package com.example.damn_rca_examen_02.entities

data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
