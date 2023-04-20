package com.example.quiz.utils

import com.example.quiz.R
import com.example.quiz.models.Question

object Constants{
    const val UserName = "username"
    const val TotalQuestions = 0
    const val Score = 0
    fun getQuestions(): MutableList<Question>{
        val questions = mutableListOf<Question>()
        questions.add(Question(
            1,
            "What country does this flag belongs to?",
            R.drawable.pak,
            "Afghanistan",
            "Pakistan",
            "India",
            "Bangladesh",
            2
        ))
        questions.add(Question(
            3,
            "What country does this flag belongs to?",
            R.drawable.india,
            "Italy",
            "Pakistan",
            "India",
            "Japan",
            3
        ))
        questions.add(Question(
            2,
            "What country does this flag belongs to?",
            R.drawable.jap,
            "Italy",
            "Japan",
            "Pakistan",
            "Brazil",
            2
        ))
        return questions
    }
}