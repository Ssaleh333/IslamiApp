package com.basicsandroid.islamiapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.basicsandroid.islamiapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(mainLooper).postDelayed({
            startHomeActivity()
        },2000)
    }

    private fun startHomeActivity() {
       val intent=Intent(this , MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}