package com.example.quiz.utils

import com.example.quiz.R
import com.example.quiz.models.Question

object Constants{
    const val UserName = "username"
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
            2,
            "What country does this flag belongs to?",
            R.drawable.india,
            "Italy",
            "Pakistan",
            "India",
            "Japan",
            3
        ))
        questions.add(Question(
            3,
            "What country does this flag belongs to?",
            R.drawable.jap,
            "Italy",
            "Japan",
            "Pakistan",
            "Brazil",
            2
        ))
        questions.add(Question(
            4,
            " Is Python code compiled or interpreted?",
            R.drawable.py,
            "Python code is both compiled and interpreted",
            "Python code is neither compiled nor interpreted",
            "Python code is only compiled",
            "Python code is only interpreted",
            1
        ))
        questions.add(Question(
            5,
            " Kotlin was developed by?",
            R.drawable.kot,
            "IBM",
            "NetBeans",
            "JetBrains",
            "Oracle",
            3
        ))
        return questions
    }
}