package com.example.quiz_app_formative_assignment_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.color.utilities.Score.score

class QuizPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declare everything

        val btnHack = findViewById<Button>(R.id.btnHack)
        val btnMyth = findViewById<Button>(R.id.btnMyth)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val tvStatement = findViewById<TextView>(R.id.tvStatement)

        // Question number
        var currentQuestion = 1
        // stores the useres score
        var score = 0

        var answered = false


        fun showQuestion() {

            while (currentQuestion <= 5) {

                Log.d("QuizPage", "Showing Question $currentQuestion")

                if (currentQuestion == 1) {
                    tvStatement.text = "Strong passwords help protect accounts."
                } else if (currentQuestion == 2) {
                    tvStatement.text = "Giving pinapple on pizza to a squirrel will make it run in slo-motion"
                } else if (currentQuestion == 3) {
                    tvStatement.text = "Updating apps improves security."
                } else if (currentQuestion == 4) {
                    tvStatement.text = "Sharing passwords with friends is recommended."
                } else if (currentQuestion == 5) {
                    tvStatement.text = "You can hold your car key fob directly against your chin, as your skull acts as an antenna, significantly increasing its range."
                }

                break
            }
        }

        showQuestion()

        btnHack.setOnClickListener {

            Log.d("QuizPage", "Hack button pressed")

            if (!answered) {

                if (currentQuestion == 1 || currentQuestion == 3 || currentQuestion == 5) {
                    score++
                    tvStatement.text = "Correct!"
                } else {
                    tvStatement.text = "Wrong!"
                }

                answered = true
            }

            btnMyth.setOnClickListener {

                Log.d("QuizPage", "Myth button pressed")

                if (!answered) {

                    if (currentQuestion == 2 || currentQuestion == 4) {
                        score++
                        tvStatement.text = "Correct!"
                    } else {
                        tvStatement.text = "Wrong!"
                    }

                    var answered = true
                }
            }
            btnNext.setOnClickListener {

                Log.d("QuizPage", "Next pressed. Current Question = $currentQuestion")

                currentQuestion++
                answered = false

                if (currentQuestion <= 5) {
                    showQuestion()
                } else {

                    Log.d("QuizPage", "Quiz finished. Final Score = $score")

                    val intent = Intent(this, ScorePage::class.java)
                    intent.putExtra("score", score)
                    startActivity(intent)
                }
            }
        }
    }
}
