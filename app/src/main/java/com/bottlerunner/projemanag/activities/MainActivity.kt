package com.bottlerunner.projemanag.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.bottlerunner.projemanag.R
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApi
import com.google.android.gms.common.api.GoogleApiClient

class MainActivity : BaseActivity() {

    lateinit var btn_sign_up:Button
    lateinit var btn_sign_in:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
//        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
//        var mGoogleApiClient = GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btn_sign_up =findViewById(R.id.btn_sign_up_intro)
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

//SHA1: 61:96:81:38:AE:97:FD:E6:51:CB:8E:94:E8:E6:4C:68:E0:9A:53:6B
