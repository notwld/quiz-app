package com.example.quiz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quiz.R
import com.example.quiz.models.Question
import com.example.quiz.utils.Constants

class QuestionActivity : AppCompatActivity() {
    private var currentPos = 1
    private lateinit var questionList: MutableList<Question>

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private lateinit var questionTxt: TextView
    private lateinit var flagImg: ImageView
    private lateinit var op1: TextView
    private lateinit var op2: TextView
    private lateinit var op3: TextView
    private lateinit var op4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        questionList = Constants.getQuestions()

        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.currentQuestion)
        questionTxt = findViewById(R.id.question)
        flagImg = findViewById(R.id.flagImg)
        op1 = findViewById(R.id.opt1)
        op2 = findViewById(R.id.opt2)
        op3 = findViewById(R.id.opt3)
        op4 = findViewById(R.id.opt4)

        setQuestion()
    }

    private fun setQuestion(){
        val q = questionList[currentPos-1]
        flagImg.setImageResource(q.img)
        progressBar.progress = currentPos
        progressText.text = "$currentPos/${progressBar.max}"

        questionTxt.text = q.question
        op1.text = q.option1
        op2.text = q.option2
        op3.text = q.option3
        op4.text = q.option4


    }
}