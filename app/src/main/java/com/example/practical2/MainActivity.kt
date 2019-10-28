package com.example.practical2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 : Button = findViewById(R.id.done_button)
        button1.setOnClickListener{ buttonClicked(button1)}
    }

    private fun buttonClicked(view : View){
        val editText = findViewById<EditText>(R.id.nickname)
        val nicknameView = findViewById<TextView>(R.id.nickname_text)

        nicknameView.text = editText.text

        editText.visibility = View.GONE

        nicknameView.visibility = View.VISIBLE

        view.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
