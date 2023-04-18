package com.example.quiz.ui

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.quiz.R
import com.example.quiz.models.Question
import com.example.quiz.utils.Constants

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var questionCounter = 1
    private var selectedAns = 0
    private var answered = false


    private lateinit var questionList: MutableList<Question>

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private lateinit var questionTxt: TextView
    private lateinit var flagImg: ImageView
    private lateinit var op1: TextView
    private lateinit var op2: TextView
    private lateinit var op3: TextView
    private lateinit var op4: TextView

    private lateinit var submitBtn: Button
    private lateinit var currentQuestion: Question

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
        submitBtn = findViewById(R.id.ansSubBtn)

        op1.setOnClickListener(this)
        op2.setOnClickListener(this)
        op3.setOnClickListener(this)
        op4.setOnClickListener(this)

        submitBtn.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion() {
        resetOption()

        val q = questionList[questionCounter - 1]
        flagImg.setImageResource(q.img)
        progressBar.progress = questionCounter
        progressText.text = "$questionCounter/${questionList.size}"

        questionTxt.text = q.question
        op1.text = q.option1
        op2.text = q.option2
        op3.text = q.option3
        op4.text = q.option4

        if (questionCounter == questionList.size) {
            submitBtn.text = "Finish"
        } else {
            submitBtn.text = "Submit"
        }
        questionCounter++
        currentQuestion = q
        answered = false
    }

    private fun resetOption() {
        var options = mutableListOf<TextView>()
        options.add(op1)
        options.add(op2)
        options.add(op3)
        options.add(op4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.border
            )
        }
    }

    private fun selectOption(txtView: TextView, optionId: Int) {
        resetOption()

        selectedAns = optionId

        txtView.setTextColor(Color.parseColor("#363A43"))
        txtView.setTypeface(txtView.typeface, Typeface.BOLD)
        txtView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_item
        )

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.opt1 -> {
                selectOption(op1, 1)
            }
            R.id.opt2 -> {
                selectOption(op2, 2)
            }
            R.id.opt3 -> {
                selectOption(op3, 3)
            }
            R.id.opt4 -> {
                selectOption(op4, 4)
            }
            R.id.ansSubBtn -> {
//                Toast.makeText(this@QuestionActivity,"You Clicked!",Toast.LENGTH_LONG).show()
                if (!answered) {
                    checkAnswer()
                } else {
                    setQuestion()
                }
            }
        }
    }

    private fun checkAnswer() {
        answered = true
        if (selectedAns == currentQuestion.correctAnswer) {
            when (selectedAns) {
                1 -> {
                    op1.background = ContextCompat.getDrawable(this, R.drawable.correct)
                }
                2 -> {
                    op2.background = ContextCompat.getDrawable(this, R.drawable.correct)
                }
                3 -> {
                    op3.background = ContextCompat.getDrawable(this, R.drawable.correct)
                }
                4 -> {
                    op4.background = ContextCompat.getDrawable(this, R.drawable.correct)
                }


            }
        } else {
            when (selectedAns) {
                1 -> {
                    op1.background = ContextCompat.getDrawable(this, R.drawable.wrong)
                }
                2 -> {
                    op2.background = ContextCompat.getDrawable(this, R.drawable.wrong)
                }
                3 -> {
                    op3.background = ContextCompat.getDrawable(this, R.drawable.wrong)
                }
                4 -> {
                    op4.background = ContextCompat.getDrawable(this, R.drawable.wrong)
                }
            }
        }
        submitBtn.text = "Next"
    }
}