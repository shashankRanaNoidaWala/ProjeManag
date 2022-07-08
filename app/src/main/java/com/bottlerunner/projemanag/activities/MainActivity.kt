package com.bottlerunner.projemanag.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.bottlerunner.projemanag.R

class MainActivity : AppCompatActivity() {

    lateinit var btn_sign_up:Button
    lateinit var btn_sign_in:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btn_sign_up =findViewById<Button>(R.id.btn_sign_up_intro)
        btn_sign_in = findViewById(R.id.btn_sign_in_intro)

        btn_sign_up.setOnClickListener{
            val intent =Intent(this, Sign_up::class.java)
            startActivity(intent)
        }
        btn_sign_in.setOnClickListener{
            startActivity(Intent(this, Sign_in::class.java))
        }

    }
}