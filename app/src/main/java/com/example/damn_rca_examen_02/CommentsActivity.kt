package com.example.damn_rca_examen_02

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.damn_rca_examen_02.adapters.CommentAdapter
import com.example.damn_rca_examen_02.network.RetrofitClient
import kotlinx.coroutines.launch

class CommentsActivity : AppCompatActivity() {

    private lateinit var recyclerViewComments: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        recyclerViewComments = findViewById(R.id.recyclerViewComments)
        recyclerViewComments.layoutManager = LinearLayoutManager(this)

        // Obtener el ID del post desde el Intent
        val postId = intent.getIntExtra("POST_ID", -1)

        if (postId != -1) {
            // Llamar a la API para obtener los comentarios
            lifecycleScope.launch {
                try {
                    val comments = RetrofitClient.apiService.getComments(postId)

                    // Configurar el adapter para los comentarios
                    recyclerViewComments.adapter = CommentAdapter(comments)
                } catch (e: Exception) {
                    Log.e("CommentsActivity", "Error al obtener los comentarios: ${e.message}")
                }
            }
        }
    }
}
