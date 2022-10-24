package com.ideaco.projectdia.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ideaco.projectdia.databinding.ActivityWelcomeBinding
import com.pixplicity.easyprefs.library.Prefs

@RequiresApi(Build.VERSION_CODES.M)
class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //install splash screen
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splashScreen.setKeepOnScreenCondition{ true }

        val isLogin = Prefs.getBoolean("isLogin", false)
        if(isLogin){
            openMainActivity()
        }else{
            openLoginActivity()
        }

    }

    private fun openMainActivity(){
        val intent = Intent(this@WelcomeActivity, ConstraintLayoutActivity::class.java)
        startActivity(intent)
    }


    private fun openLoginActivity(){
        val intent = Intent(this@WelcomeActivity, VerifyOtpActivity::class.java)
        startActivity(intent)
    }
}