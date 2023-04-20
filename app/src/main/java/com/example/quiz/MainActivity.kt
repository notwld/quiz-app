package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quiz.ui.QuestionActivity
import com.example.quiz.utils.Constants
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name: EditText = findViewById(R.id.name)
        val subBtn: Button = findViewById(R.id.submitBtn)

        subBtn.setOnClickListener {
            if (!name.text.isEmpty()) {
                Intent(this@MainActivity,QuestionActivity::class.java).also {
                    it.putExtra(Constants.UserName,name.text.toString())
                    startActivity(it)
                    finish()
                }
            }
            else{
                Toast.makeText(this@MainActivity,"Please Enter Your Name",Toast.LENGTH_LONG).show()
            }
        }

    }
}