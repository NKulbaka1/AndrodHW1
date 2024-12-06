package com.example.helloandriod

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var enteredName: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        enteredName = findViewById(R.id.enteredName)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = enteredName.text.toString()
            val intent = Intent().apply {
                putExtra("name", name)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}