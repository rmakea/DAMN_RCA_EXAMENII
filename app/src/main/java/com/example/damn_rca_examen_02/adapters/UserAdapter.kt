package com.example.damn_rca_examen_02.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.damn_rca_examen_02.PostsActivity
import com.example.damn_rca_examen_02.R
import com.example.damn_rca_examen_02.entities.User

class UserAdapter(
    private val userList: List<User>,
    private val onUserClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Name: TextView = view.findViewById(R.id.tvName)
        val userName: TextView = view.findViewById(R.id.tvUsername)
        val userEmail: TextView = view.findViewById(R.id.tvEmail)
        val userphone: TextView = view.findViewById(R.id.tvPhone)
        val website: TextView = view.findViewById(R.id.tvWebSite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.Name.text = user.name
        holder.userName.text = user.username
        holder.userEmail.text = user.email
        holder.userphone.text = user.phone
        holder.website.text = user.website

        // Agregar listener para clic corto
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PostsActivity::class.java)
            intent.putExtra("USER_ID", user.id)
            holder.itemView.context.startActivity(intent)
            Log.d("cat","Clik corto ${user}")
        }

    }

    override fun getItemCount(): Int = userList.size
}

