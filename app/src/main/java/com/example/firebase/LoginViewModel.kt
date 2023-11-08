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

//inyeccion de dependencias
class LoginViewModel @Inject constructor(): ViewModel() {

    //val es algo que nunca se puede cambiar
    //var si se puede sobre escribir
    //   val nombre: String = ""
    val firebase: FirebaseAuth = Firebase.auth
    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")

    fun createAccount(email: String, password: String) {
        firebase.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                //Todo resulta correcto
            } else {
                //Error
            }
        }
    }
    fun login(email: String, password: String){
        firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                //TODO resulta correcto
            } else {
                //TODO Error
            }
        }
    }
}