package com.unsa.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val retrofit = RetrofitHelper.getRetrofitInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Threads and Coroutines on Android
        // Main: User Interface Thread
        // IO: Long but light processes
        // Default: Heavy processes
        lifecycleScope.launch(Dispatchers.IO) {
            retrofit.getSuperHeroes("a")
        }
    }
}
