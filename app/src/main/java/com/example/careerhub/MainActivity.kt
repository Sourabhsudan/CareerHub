package com.example.careerhub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.careerhub.Models.UserPost
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private var adapter : UserPostAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeButton : ImageView = findViewById(R.id.homeButton)
        val candidateButton : ImageView = findViewById(R.id.candidateButton)
        val signOutButton : ImageView = findViewById(R.id.signOutButton)
        homeButton.setOnClickListener {
            // Start MainActivity
            startActivity(Intent(this, MainActivity::class.java))
        }

        candidateButton.setOnClickListener {
            // Start CandidateActivity
            startActivity(Intent(this, CandidateActivity::class.java))
        }
        signOutButton.setOnClickListener {

            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this, SignInActivity::class.java))

            finish()
        }

        val query = FirebaseDatabase.getInstance().reference.child("UserPost")
        val options = FirebaseRecyclerOptions.Builder<UserPost>().setQuery(query, UserPost::class.java).build()
        adapter = UserPostAdapter(options)

        val prView : RecyclerView = findViewById(R.id.prView)
        prView.layoutManager= LinearLayoutManager(this)
        prView.adapter = adapter

    }

    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
}