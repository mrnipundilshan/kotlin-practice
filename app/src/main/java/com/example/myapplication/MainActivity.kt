package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val showButton: Button = findViewById(R.id.showButton)

        showButton.setOnClickListener { showAlertDialog() }
    }

    private fun showAlertDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Snapchat")
            .setMessage("Do you want to uninstall the app?")
            .setPositiveButton("Yes"){dialog, which ->
                Toast.makeText(this, "The app is successfully uninstalled", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){dialog, which ->
                dialog.dismiss()
            }
        val alertDialog : AlertDialog = builder.create()
        alertDialog.show()
    }
}