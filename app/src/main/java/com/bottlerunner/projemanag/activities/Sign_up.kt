package com.bottlerunner.projemanag.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bottlerunner.projemanag.R
import java.net.PasswordAuthentication

class Sign_up : BaseActivity() {

    lateinit var et_name:EditText
    lateinit var et_email:EditText
    lateinit var et_password:EditText
    lateinit var btn_sign_up: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        et_name = findViewById(R.id.et_name)
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        btn_sign_up = findViewById(R.id.btn_sign_up)

        btn_sign_up.setOnClickListener{
            registerUser()
        }
    }

    private fun registerUser(){
        val name:String = et_name.text.toString().trim{ it <= ' '}          //what is this?
        val email:String = et_email.text.toString().trim{ it <= ' '}
        val password:String = et_password.text.toString().trim{ it <= ' '}

        if(validateForm(name,email,password)){
            Toast.makeText(this,"Darling darling stand, stand by me, stand, stand by, stand by me, stand by me, stand by me",Toast.LENGTH_LONG).show()
        }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean{
        if(name.length == 0){
            showError("Please enter a valid name")
            return false
        }
        if(email.length == 0){
            showError("Please enter a valid email")
            return true
        }
        if(password.length == 0){
            showError("Please enter a valid password")
            return false
        }
        return true
    }
}