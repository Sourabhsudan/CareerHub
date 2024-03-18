package com.example.careerhub

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity(){
    private val Splash_Delay: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity((Intent(this, SignInActivity::class.java)))
            finish()
        }, Splash_Delay)


    }
}