package com.example.careerhub


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.careerhub.Models.UserPost
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class UserPostAdapter ( options: FirebaseRecyclerOptions<UserPost>):
    FirebaseRecyclerAdapter<UserPost, UserPostAdapter.MyViewHolder>(options)
{

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
        model: UserPost
    ) {
        val storageRef : StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.image)
        Glide.with(holder.userImg.context).load(storageRef).into(holder.userImg)
        holder.userName.text = model.username
        holder.postDescription.text = model.description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, CandidateActivity::class.java)
            intent.putExtra("username", model.username)
            context.startActivity(intent)
        }
    }
    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        :RecyclerView.ViewHolder(inflater. inflate(R.layout.post_layout, parent, false) )
    {
        val userName : TextView = itemView.findViewById(R.id.userName)
        val postDescription : TextView = itemView.findViewById(R.id.postDescription)
        val userImg : ImageView = itemView.findViewById(R.id.userImg)
    }

}