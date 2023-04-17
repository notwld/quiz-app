package com.example.quiz.models

data class Question(
    val id:Int,
    val question: String,
    val img: Int,
    val option1:String,
    val option2:String,
    val option3:String,
    val option4:String,
    val correctAnswer:Int
)