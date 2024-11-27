package com.example.damn_rca_examen_02

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.damn_rca_examen_02.adapters.UserAdapter
import com.example.damn_rca_examen_02.network.RetrofitClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewUsers: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewUsers = findViewById(R.id.recyclerViewUsers)
        recyclerViewUsers.layoutManager = LinearLayoutManager(this)

        // Llamada a la API dentro de una coroutine
        lifecycleScope.launch {
            try {
                val users = RetrofitClient.apiService.getUsers()

                // Configurar el Adapter y asignarlo al RecyclerView
                recyclerViewUsers.adapter = UserAdapter(users) { user ->
                    // Acción al hacer clic en un usuario
                    Toast.makeText(this@MainActivity, "Clic en: ${user.name}", Toast.LENGTH_SHORT).show()
                    Log.e("cat", "user activity: ${user}")
                }

            } catch (e: Exception) {
                Log.e("cat", "Error al obtener los usuarios: ${e.message}")
            }
        }
    }
}

