package com.example.damn_rca_examen_02.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.damn_rca_examen_02.R
import com.example.damn_rca_examen_02.entities.Comment

class CommentAdapter(
    private val commentList: List<Comment>
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val commentName: TextView = view.findViewById(R.id.tvCommentName)
        val commentEmail: TextView = view.findViewById(R.id.tvCommentEmail)
        val commentBody: TextView = view.findViewById(R.id.tvCommentBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = commentList[position]
        holder.commentName.text = comment.name
        holder.commentEmail.text = comment.email
        holder.commentBody.text = comment.body
    }

    override fun getItemCount(): Int = commentList.size
}
