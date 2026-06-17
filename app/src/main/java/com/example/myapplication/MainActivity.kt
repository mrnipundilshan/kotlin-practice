package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        //Explicit Intent
        val explicitButton = findViewById<Button>(R.id.explicitButton)

        explicitButton.setOnClickListener {
            val explicitIntent = Intent(this, secondActivity::class.java)
            startActivity(explicitIntent)
            //finish()
        }

        // Implicit Intent
        val url = "https://www.google.com"
        val implicitButton = findViewById<Button>(R.id.implicitButton)

        implicitButton.setOnClickListener { 
            val implicitIntent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(implicitIntent)
        }

    }
}