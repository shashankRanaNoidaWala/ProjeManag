package com.bottlerunner.projemanag.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bottlerunner.projemanag.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Sign_in : BaseActivity() {

    private lateinit var auth:FirebaseAuth
    private lateinit var et_email_sign_in:EditText
    private lateinit var et_password_sign_in:EditText
    private lateinit var btn_sign_in_sign_in: Button
    lateinit var email:String
    lateinit var password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        et_email_sign_in =findViewById(R.id.et_email_sign_in)
        et_password_sign_in = findViewById(R.id.et_password_sign_in)
        btn_sign_in_sign_in = findViewById(R.id.btn_sign_in_sign_in)

        auth =  Firebase.auth



        btn_sign_in_sign_in.setOnClickListener{
            email = et_email_sign_in.text.toString().trim{ it <= ' '}
            password= et_password_sign_in.text.toString().trim{ it <= ' '}
            if(validateForm(email,password)){
                signInUser(email, password)
            }
        }
    }


    fun validateForm(email: String, password: String): Boolean{

        if(email.isEmpty()){
            showError("Please enter a valid email $email daalo")
            return false
        }
        if(password.isEmpty()){
            showError("Please enter a valid password")
            return false
        }
        return true
    }

    fun signInUser(email: String, password: String){
        Toast.makeText(this,"Darling darling stand, stand by me, stand, stand by, stand by me, stand by me, stand by me",Toast.LENGTH_LONG).show()
        showProgressDialog("Thamba thamba")
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {      //This is lamda function
            hideProgressDialog()                                                                                        //Know how to make it a regular one
            if (it.isSuccessful) {
                val firebaseUser = it.result!!.user!!
                val registeredEmail = firebaseUser.email!!
                Toast.makeText(
                    this,
                    "${firebaseUser.email} you have successfully logged in",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}