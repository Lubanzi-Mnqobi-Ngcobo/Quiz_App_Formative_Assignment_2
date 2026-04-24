package com.example.quiz_app_formative_assignment_2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvReview = findViewById<TextView>(R.id.tvReview)
        val btnBack = findViewById<Button>(R.id.btnBack)

        Log.d("ReviewPage", "Displaying review answers")

        tvReview.text =
            "1. Strong passwords help protect accounts. - Life Hack\n\n" +
                    "2. Giving pinapple on pizza to a squirrel will make it run in slo-motion. - Myth\n\n" +
                    "3. Updating apps improves security. - Life Hack\n\n" +
                    "4. Sharing passwords with friends is recommended. - Myth\n\n" +
                    "5. You can hold your car key fob directly against your chin, as your skull acts as an antenna, significantly increasing its range. - Life Hack\n\n"

        btnBack.setOnClickListener {

            Log.d("ReviewPage", "Back button pressed")

            finish()
        }
    }
}