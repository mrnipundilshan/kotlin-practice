package com.example.myapplication

import android.os.Bundle
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import android.os.Handler

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var isRunning = false
    private var timerSeconds = 0

    private val handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener { startTimer() }

        binding.stopBtn.setOnClickListener { stopTimer() }

        binding.resetBtn.setOnClickListener { resetTimer() }

    }

    private val runnable = object : Runnable {
        override fun run() {
          timerSeconds++
            val hours = timerSeconds / 3600
            val minutes = (timerSeconds % 3600) / 60
            val seconds = timerSeconds % 60

            val time = String.format("%02d:%02d:%02d", hours, minutes, seconds)
            binding.timerText.text = time

            handler.postDelayed(this, 1000)
        }
    }


    private  fun startTimer(){
        if (!isRunning){
            handler.postDelayed(runnable, 1000)
            isRunning = true

            binding.startBtn.isEnabled = false
            binding.stopBtn.isEnabled = true
            binding.resetBtn.isEnabled = true
        }
    }

    private fun stopTimer(){
        if(isRunning){
            handler.removeCallbacks(runnable)
            isRunning = false

            binding.startBtn.isEnabled = true
            binding.startBtn.text = "Resume"
            binding.stopBtn.isEnabled = false
            binding.resetBtn.isEnabled =  true
        }
    }

    private fun resetTimer(){
        stopTimer()

        timerSeconds = 0
        binding.timerText.text = "00:00:00"

        binding.startBtn.isEnabled = true
        binding.resetBtn.isEnabled = false
        binding.startBtn.text = "Start"
    }
}