package com.example.quiz_app_formative_assignment_2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.util.Log

class ScorePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvScore = findViewById<TextView>(R.id.tvScore)
        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val score = intent.getIntExtra("score", 0)

        Log.d("ScorePage", "Received score = $score")

        tvScore.text = "Your Score: $score / 5"

        if (score >= 4) {
            tvFeedback.text = "You did amazingly, you're so cool"
            Log.d("ScorePage", "Feedback: You did amazingly, you're so cool")
        } else if (score >= 2) {
            tvFeedback.text = "Good effort!"
            Log.d("ScorePage", "Feedback: Good effort!")
        } else {
            tvFeedback.text = "Keep trying, you'll do better next time!"
            Log.d("ScorePage", "Feedback: Keep trying, you'll do better next time!")
        }

        btnReview.setOnClickListener {

            Log.d("ScorePage", "Review button pressed")

            val intent = Intent(this, ReviewPage::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {

            Log.d("ScorePage", "Exit button pressed")

            finishAffinity()
        }
    }
}