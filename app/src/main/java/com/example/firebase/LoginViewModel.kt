package com.example.firebase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class LoginViewModel @Inject constructor(): ViewModel() {

    val firebase: FirebaseAuth = Firebase.auth

    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")

    fun createAccount (email: String, password: String){
        firebase.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
            if (it.isSuccessful){
                //Todo respuesta correcta
            }else{
                //Todo tronco
            }
        }
    }

    fun login(email: String, password: String){
        firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                //Todo respuesta correcta
            } else {
                //Todo tronco
            }
        }
    }


}