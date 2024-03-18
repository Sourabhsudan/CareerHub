package com.example.careerhub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.careerhub.Models.CandidateData
import com.google.firebase.firestore.FirebaseFirestore

class CandidateActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CandidateAdapter

    private val db = FirebaseFirestore.getInstance()
    private val candidateDataCollection = db.collection("CandidateData")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate)
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
            startActivity(Intent(this, SignInActivity::class.java))
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CandidateAdapter()
        recyclerView.adapter = adapter
        loadCandidateData()
    }

    private fun loadCandidateData() {
        candidateDataCollection.get()
            .addOnSuccessListener { result ->
                val candidateList = mutableListOf<CandidateData>() // Initialize the list
                for (document in result) {
                    val name = document.getString("name") ?: ""
                    val experience = document.getString("experience") ?: ""
                    val email = document.getString("email") ?: ""
                    val candidate = CandidateData(name, experience, email)
                    candidateList.add(candidate)
                }

            }
            .addOnFailureListener { exception ->

            }
    }
}
