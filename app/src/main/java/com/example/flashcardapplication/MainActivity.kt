package com.example.flashcardapplication

import android.os.Bundle
import android.view.View
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Call edge-to-edge function here
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        // Optional: Adjust content when window insets are applied (system bars)
        val mainLayout = findViewById<View>(R.id.main)  // Make sure to use the correct root layout ID
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Adjust padding to avoid content being hidden under system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // Return insets so the system can track it
        }
    }

    // Enable edge-to-edge layout
    private fun enableEdgeToEdge() {
        // Make content extend under status bar and navigation bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT  // Optional: Set transparent status bar
    }
}
