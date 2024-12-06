package com.example.helloandriod

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var greetingButton: Button
    private lateinit var greetingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetingButton = findViewById(R.id.greetingButton)
        greetingTextView = findViewById(R.id.greetingTextView)

        greetingButton.setOnClickListener {
            val greeting = "Привет"
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("greeting", greeting)
            }
            startActivityForResult(intent, SHOW_OTHER_ACTIVITY)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SHOW_OTHER_ACTIVITY && resultCode == RESULT_OK) {
            val name = data?.getStringExtra("name")
            greetingTextView.text = "Привет, $name!"
        }
    }

    companion object {
        private const val SHOW_OTHER_ACTIVITY = 1
    }
}