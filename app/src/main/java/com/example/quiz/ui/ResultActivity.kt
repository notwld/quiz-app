package com.example.quiz.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.quiz.MainActivity
import com.example.quiz.R
import com.example.quiz.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var finishBtn:Button
    private lateinit var score: TextView
    private lateinit var img: ImageView
    private lateinit var name: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        score = findViewById(R.id.score)
        img = findViewById(R.id.resultImg)
        name = findViewById(R.id.user)
        finishBtn = findViewById(R.id.finishBtn)

        finishBtn.setOnClickListener {
            Intent(this@ResultActivity,MainActivity::class.java).also {
                startActivity(it)
            }
        }

        val _name = intent.getStringExtra(Constants.UserName)

        val _score = intent.getIntExtra(Constants.Score.toString(),0)
        val questions = Constants.getQuestions().size
        score.text = _score.toString() + " out of $questions"

        if (_score>questions/2){
            img.setImageResource(R.drawable.won)
            name.text ="Congratulations! " + _name.toString().uppercase()

        }
        else{
            img.setImageResource(R.drawable.lost)
            name.text ="Better Luck Next Time! " + _name.toString().uppercase()

        }
    }
}