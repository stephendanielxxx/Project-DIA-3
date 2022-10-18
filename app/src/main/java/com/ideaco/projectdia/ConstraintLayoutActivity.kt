package com.ideaco.projectdia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ConstraintLayoutActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)

        button = findViewById(R.id.btnChangeActivity)

        button.setOnClickListener {
            Toast.makeText(this@ConstraintLayoutActivity,
                "Button di click", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@ConstraintLayoutActivity,
                RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}