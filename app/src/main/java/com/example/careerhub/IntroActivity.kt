package com.example.careerhub

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper

class IntroActivity : AppCompatActivity(){
    private val Splash_Delay: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity((Intent(this, MainActivity::class.java)))
            finish()
        }, Splash_Delay)


    }
}