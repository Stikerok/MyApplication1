package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvResult: TextView
    lateinit var etMessage: EditText
    lateinit var etId: EditText
    lateinit var btSend: Button
    var message: Message? = null
    var currentId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etMessage = findViewById(R.id.editTextMessage)
        etId = findViewById(R.id.editTextUserId)
        btSend = findViewById(R.id.button2)
        tvResult = findViewById(R.id.text)
        btSend.setOnClickListener {
            if (etId.text.isNotEmpty()) {
                currentId = etId.text.toString().toInt()
                if (etMessage.text.isNotEmpty()) {
                    val currentMessage = Message(initId = currentId, text = etMessage.text.toString())
                    message = if (message == null) {
                        currentMessage
                    } else {
                        message!! + currentMessage
                    }
                    etMessage.setText("")
                    tvResult.text = message.toString()
                }
            }
        }
    }
}