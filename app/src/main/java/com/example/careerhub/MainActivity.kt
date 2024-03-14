package com.example.careerhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.careerhub.Models.UserPost
import com.example.careerhub.Models.UserPostAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private var adapter : UserPostAdapter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val query = FirebaseDatabase.getInstance().reference.child("UserPost")
        val options = FirebaseRecyclerOptions.Builder<UserPost>().setQuery(query, UserPost::class.java).build()
        adapter = UserPostAdapter(options)

        val postrView : RecyclerView = findViewById(R.id.postrView)
        postrView.layoutManager= LinearLayoutManager(this)
        postrView.adapter = adapter

    }

    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
}