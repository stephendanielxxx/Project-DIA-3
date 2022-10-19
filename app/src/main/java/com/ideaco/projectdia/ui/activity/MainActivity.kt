package com.ideaco.projectdia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ideaco.projectdia.R
import com.ideaco.projectdia.databinding.ActivityMainBinding
import com.ideaco.projectdia.ui.fragment.HomeFragment
import com.ideaco.projectdia.ui.fragment.ProfileFragment
import com.ideaco.projectdia.ui.fragment.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(R.id.container, HomeFragment.newInstance("", ""))

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    //open fragment home
                    showFragment(R.id.container, HomeFragment.newInstance("", ""))
                }
                R.id.menu_profile -> {
                    //open fragment profile
                    showFragment(R.id.container, ProfileFragment.newInstance("", ""))
                }
                R.id.menu_setting -> {
                    //open fragment setting
                    showFragment(R.id.container, SettingFragment.newInstance("", ""))
                }
            }
            true
        }
    }

    fun showFragment(id: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }
}