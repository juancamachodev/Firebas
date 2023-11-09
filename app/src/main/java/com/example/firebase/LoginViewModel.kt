package com.example.firebase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginViewModel: ViewModel() {


    //val firebase: FirebaseAuth = Firebase.auth

    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")

    fun createAccount(email: String, password: String){

    }

}