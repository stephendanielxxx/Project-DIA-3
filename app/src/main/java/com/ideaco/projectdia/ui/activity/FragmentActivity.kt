package com.ideaco.projectdia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ideaco.projectdia.R
import com.ideaco.projectdia.databinding.ActivityFragmentBinding
import com.ideaco.projectdia.ui.fragment.BlackFragment
import com.ideaco.projectdia.ui.fragment.GreenFragment

class FragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // create black fragment instance
        val blackFragment = BlackFragment.newInstance("", "")
        // assign black fragment instance to R.id.frame1
        supportFragmentManager.beginTransaction().replace(R.id.frame1, blackFragment).commit()

        val greenFragment = GreenFragment.newInstance("", "")
        supportFragmentManager.beginTransaction().replace(R.id.frame2, greenFragment).commit()
    }
}