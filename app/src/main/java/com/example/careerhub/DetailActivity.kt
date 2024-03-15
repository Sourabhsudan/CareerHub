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
        val txtName = findViewById<TextView>(R.id.CandidateName)
        val txtUserId = findViewById<TextView>(R.id.userIdTextView)
        val txtEmail = findViewById<TextView>(R.id.emailTextView)
        val txtAddress = findViewById<TextView>(R.id.addressTextView)
        val txtQualification = findViewById<TextView>(R.id.qualificationTextView)
        val txtExperience = findViewById<TextView>(R.id.experienceTextView)

        val img = intent.getStringExtra("profile_img")
        val name = intent.getStringExtra("user_name")
        val userId = intent.getStringExtra("user_id")
        val email = intent.getStringExtra("email")
        val address = intent.getStringExtra("address")
        val qualification = intent.getStringExtra("qualifications")
        val experience = intent.getStringExtra("experience")


    }
}