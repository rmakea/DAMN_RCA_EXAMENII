package com.example.damn_rca_examen_02.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.damn_rca_examen_02.CommentsActivity
import com.example.damn_rca_examen_02.R
import com.example.damn_rca_examen_02.entities.Post

class PostAdapter(
    private val postList: List<Post>,
    private val onPostClick: (Post) -> Unit
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitle: TextView = view.findViewById(R.id.tvPostTitle)
        val postBody: TextView = view.findViewById(R.id.tvPostBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.postTitle.text = post.title
        holder.postBody.text = post.body

        // Agregar listener para clic corto
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CommentsActivity::class.java)
            intent.putExtra("POST_ID", post.id)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = postList.size
}

