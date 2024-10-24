package com.example.mathquizsolo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class QuizPage : AppCompatActivity(), View.OnClickListener {

    private lateinit var quizType: String
    private lateinit var quizDisplay: TextView
    private lateinit var quizAnswer: EditText
    private lateinit var status: TextView
    private var correctAnswer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_page)

        quizType = intent.getStringExtra("QuizType") ?: "addition"
        quizDisplay = findViewById(R.id.Quiz)
        quizAnswer = findViewById(R.id.Answer)
        status = findViewById(R.id.Status)

        correctAnswer = generateQuiz(quizType, quizDisplay)

        val checkButton: Button = findViewById(R.id.CheckAnswer)
        val newQuizButton: Button = findViewById(R.id.newQuizButton)

        checkButton.setOnClickListener(this)
        newQuizButton.setOnClickListener {
            correctAnswer = generateQuiz(quizType, quizDisplay)
            status.text = ""
            quizAnswer.text.clear()
        }
    }

    private fun generateQuiz(quizType: String, quizDisplay: TextView): Int {
        val number1: Int = Random.nextInt(1, 100)
        val number2: Int = Random.nextInt(1, 100)
        var correctAnswer: Int = 0

        when (quizType) {
            "addition" -> {
                correctAnswer = number1 + number2
                quizDisplay.text = "$number1 + $number2"
            }
            "subtraction" -> {
                correctAnswer = number1 - number2
                quizDisplay.text = "$number1 - $number2"
            }
            "multiplication" -> {
                correctAnswer = number1 * number2
                quizDisplay.text = "$number1 * $number2"
            }
            "division" -> {
                correctAnswer = number1 / number2
                quizDisplay.text = "$number1 / $number2"
            }
        }

        return correctAnswer
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.CheckAnswer -> {
                    val userAnswer = quizAnswer.text.toString().toIntOrNull()
                    if (userAnswer != null && userAnswer == correctAnswer) {
                        status.text = "Correct"
                    } else {
                        status.text = "Incorrect"
                    }
                }
            }
        }
    }
}
