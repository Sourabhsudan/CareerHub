package com.example.careerhub

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgView = findViewById<ImageView>(R.id.detailImageView)
        val name = findViewById<TextView>(R.id.CandidateName)
        val userId = findViewById<TextView>(R.id.userIdTextView)
        val email = findViewById<TextView>(R.id.emailTextView)
        val address = findViewById<TextView>(R.id.addressTextView)
        val qualification = findViewById<TextView>(R.id.qualificationTextView)
        val experience = findViewById<TextView>(R.id.experienceTextView)

    }
}