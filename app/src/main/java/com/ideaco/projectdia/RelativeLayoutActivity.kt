package com.ideaco.projectdia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RelativeLayoutActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        textView = findViewById(R.id.tvHello)

        textView.text = "Hello World"
    }
}