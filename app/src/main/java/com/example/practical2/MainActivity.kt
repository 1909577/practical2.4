package com.example.practical2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.practical2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val myName: MyName = MyName("Aleks Haecky")
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val button1 : Button = binding.doneButton

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }


    }


    private fun addNickname(view: View){
        binding.apply{
            myName?.nickname = nickname.text.toString()
            invalidateAll()
            nickname.visibility=View.GONE
            doneButton.visibility=View.GONE
            nicknameText.visibility=View.VISIBLE
        }

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

    /*private fun buttonClicked(view : View){
        val editText = findViewById<EditText>(R.id.nickname)
        val nicknameView = findViewById<TextView>(R.id.nickname_text)

        nicknameView.text = editText.text

        editText.visibility = View.GONE

        nicknameView.visibility = View.VISIBLE

        view.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }*/
}
