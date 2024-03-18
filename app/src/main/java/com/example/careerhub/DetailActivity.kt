package com.example.careerhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.careerhub.Models.CandidateData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DetailActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgView = findViewById<ImageView>(R.id.detailImageView)
        val txtName = findViewById<TextView>(R.id.CandidateName)
        val txtUserId = findViewById<TextView>(R.id.userIdTextView)
        val txtEmail = findViewById<TextView>(R.id.emailTextView)
        val txtAddress = findViewById<TextView>(R.id.addressTextView)
        val txtQualification = findViewById<TextView>(R.id.qualificationTextView)
        val txtExperience = findViewById<TextView>(R.id.experienceTextView)
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

        // Initialize Firebase
        database = FirebaseDatabase.getInstance().reference.child("candidates")

        // Retrieve data from Firebase using user_id passed from MainActivity
        val userId = intent.getStringExtra("user_id")
        if (userId != null) {
            database.child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val candidateData = dataSnapshot.getValue(CandidateData::class.java)
                    candidateData?.let {
                        // Update UI with retrieved data
                        Glide.with(this@DetailActivity).load(it.profile_img).into(imgView)
                        txtName.text = it.user_name
                        txtUserId.text = it.user_id
                        txtEmail.text = it.email
                        txtAddress.text = it.address
                        txtQualification.text = it.qualifications
                        txtExperience.text = it.experience
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle database error
                    Toast.makeText(this@DetailActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                }
            })
        }

        val connectButton = findViewById<Button>(R.id.connect)
        connectButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
        }
    }
}
