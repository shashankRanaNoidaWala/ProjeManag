package com.bottlerunner.projemanag.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.bottlerunner.projemanag.R
import com.google.firebase.auth.FirebaseAuth


open class BaseActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false
    private lateinit var mProgressDialog: Dialog
    private lateinit var tv_progress_bar:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        tv_progress_bar =findViewById(R.id.tv_progress_text)
    }

    fun showProgressDialog(text: String){
        mProgressDialog = Dialog(this)
        mProgressDialog.setContentView(R.layout.dialog_progress)

        mProgressDialog.findViewById<TextView>(R.id.tv_progress_text).text = text
        mProgressDialog.show()
    }

    fun hideProgressDialog() {
        mProgressDialog.dismiss()
    }

    fun getCurrentUserID(): String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

    fun doubleBackToExit(){
        if(doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce= true
        Toast.makeText(this,"Please press back again to exit", Toast.LENGTH_SHORT).show()


    }
}