package com.route.islamic37

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.route.islamic37.main_activity.MainActivity

class SplashActivity : AppCompatActivity() {
    /*
        mdpi -> base (1.0)
        ldpi -> 1.2
        xhdpi-> 1.4
        xxhdpi -> 1.6
        xxhdpi -> 2
        1- Pixels issue
        2- Processing , memory allocation
            1 -> 4 Bytes -> RGB A
            618*1305 = 100000



     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent1 = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent1)
            finish()
        }, 2000)
    }
}