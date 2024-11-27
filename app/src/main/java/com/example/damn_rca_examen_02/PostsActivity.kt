package com.example.damn_rca_examen_02

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.damn_rca_examen_02.adapters.PostAdapter
import com.example.damn_rca_examen_02.network.RetrofitClient
import kotlinx.coroutines.launch

class PostsActivity : AppCompatActivity() {

    private lateinit var recyclerViewPosts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        recyclerViewPosts = findViewById(R.id.recyclerViewPosts)
        recyclerViewPosts.layoutManager = LinearLayoutManager(this)

        // Obtener el ID del usuario desde el Intent
        val userId = intent.getIntExtra("USER_ID", -1)

        if (userId != -1) {
            // Llamar a la API para obtener los posts
            lifecycleScope.launch {
                try {
                    val posts = RetrofitClient.apiService.getPosts(userId)

                    // Configurar el adapter para los posts
                    recyclerViewPosts.adapter = PostAdapter(posts) { post ->
                        Toast.makeText(
                            this@PostsActivity,
                            "Clic en post: ${post.title}",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.e("cat", "post activity: ${post}")
                    }
                } catch (e: Exception) {
                    Log.e("cat", "Error al obtener los posts: ${e.message}")
                }
            }
        }
    }
}
