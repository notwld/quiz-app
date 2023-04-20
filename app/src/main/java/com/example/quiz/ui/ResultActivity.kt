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
        name.text = _name.toString().uppercase()

        val _score = intent.getIntExtra(Constants.Score.toString(),0)
        val questionLen = intent.getIntExtra(Constants.TotalQuestions.toString(),0)

        score.text = _score.toString()

        if (_score>questionLen.toInt()/2){
            img.setImageResource(R.drawable.won)
        }
        else{
            img.setImageResource(R.drawable.lost)
        }
    }
}