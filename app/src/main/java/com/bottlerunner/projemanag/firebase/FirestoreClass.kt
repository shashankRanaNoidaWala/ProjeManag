package com.bottlerunner.projemanag.firebase

import com.bottlerunner.projemanag.activities.Sign_in
import com.bottlerunner.projemanag.activities.Sign_up
import com.bottlerunner.projemanag.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase

class FirestoreClass {

    private val firestore = FirebaseFirestore.getInstance()

    fun registerUser(activity: Sign_up, userInfo: com.bottlerunner.projemanag.models.User){
        firestore.collection(Constants.USERS).document(getCurrentUserId()).set(userInfo, SetOptions.merge()).addOnSuccessListener {
            activity.userRegisterSuccess()
        }
    }

    fun getCurrentUserId(): String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
}