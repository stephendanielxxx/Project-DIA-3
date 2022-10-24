package com.ideaco.projectdia.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ideaco.projectdia.databinding.ActivityConstraintLayoutBinding

class ConstraintLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConstraintLayoutBinding
//    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConstraintLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        button = findViewById(R.id.btnChangeActivity)

        binding.btnChangeActivity.setOnClickListener {
            Toast.makeText(this@ConstraintLayoutActivity,
                "Button di click", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@ConstraintLayoutActivity,
                RelativeLayoutActivity::class.java)
            intent.putExtra("key_hello", "Ini dari constraint activity")
            intent.putExtra("key_welcome", "beda lagi")
            startActivity(intent)
        }

        binding.btnFragment.setOnClickListener {
            val intent = Intent(this@ConstraintLayoutActivity, FragmentActivity::class.java)
            startActivity(intent)
        }

        binding.btnBottom.setOnClickListener {
            val intent = Intent(this@ConstraintLayoutActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnRandomAnimal.setOnClickListener {
            val intent = Intent(this@ConstraintLayoutActivity, RandomAnimalActivity::class.java)
            startActivity(intent)
        }

        binding.btnRandomAnimals.setOnClickListener {
            val intent = Intent(this@ConstraintLayoutActivity, RandomAnimalsActivity::class.java)
            startActivity(intent)
        }

        binding.btnVerifyOtp.setOnClickListener {
            val intent = Intent(this@ConstraintLayoutActivity, VerifyOtpActivity::class.java)
            startActivity(intent)
        }

        binding.btnFavoriteAnimals.setOnClickListener {
            val intent = Intent(this@ConstraintLayoutActivity, FavoriteAnimalsActivity::class.java)
            startActivity(intent)
        }
    }
}