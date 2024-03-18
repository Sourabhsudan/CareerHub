package com.example.careerhub

import CandidateAdapter

import android.content.Intent
import android.os.Bundle

import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.careerhub.Models.CandidateData

import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class CandidateActivity : AppCompatActivity() {

    private lateinit var Adapter: CandidateAdapter
    private lateinit var DatabaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate)


        DatabaseRef = FirebaseDatabase.getInstance().getReference("candidates")

        // Set up RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val query = DatabaseRef.orderByChild("title")


        val options = FirebaseRecyclerOptions.Builder<CandidateData>()
            .setQuery(query, CandidateData::class.java)
            .build()

        Adapter = CandidateAdapter(this, options)
        recyclerView.adapter = Adapter


        val homeButton = findViewById<ImageView>(R.id.homeButton)
        val signOutButton = findViewById<ImageView>(R.id.signOutButton)

        homeButton.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
        }

        signOutButton.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        Adapter.stopListening()
    }
}
