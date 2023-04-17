package com.example.quiz.utils

import com.example.quiz.R
import com.example.quiz.models.Question

object Constants{
    fun getQuestions(): MutableList<Question>{
        val questions = mutableListOf<Question>()
        questions.add(Question(
            1,
            "What country is this flag is?",
            R.drawable.pepo,
            "Afghanistan",
            "Pakistan",
            "India",
            "Bangladesh",
            1
        ))
        return questions
    }
}