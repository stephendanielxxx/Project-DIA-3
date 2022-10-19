package com.ideaco.projectdia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ideaco.projectdia.R

class RelativeLayoutActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        val text = intent.getStringExtra("key_hello")

        textView = findViewById(R.id.tvHello)

        textView.text = text
    }
}