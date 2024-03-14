package com.example.careerhub

import CandidateAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.careerhub.Models.CandidateData
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class  CandidateActivity : AppCompatActivity() {
    private var adapter: CandidateAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val query = FirebaseDatabase.getInstance().reference.child("CandidateData")
        val options = FirebaseRecyclerOptions.Builder<CandidateData>().setQuery(query, CandidateData::class.java).build()
        adapter = CandidateAdapter(options)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
        }
}