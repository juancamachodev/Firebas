package com.example.firebase

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    val dataLogin = DataLogin()

    enum class StatusLogin {
        AUN_NO_LOGUEADO,
        LOGEADO,
        ERROR_USUARIO_OR_PASSWORD,
        ERROR_DE_RED
    }

    enum class StatusCreateAccount() {
        INICIO,
        NO_ES_UN_CORREO_VALIDO,
        SI_JALISCO,
        PASSWORD_NO_VALIDO,
        ERROR_GENERAL
    }

    init {
        /**
         * Regex para comparar y validar cadenas
         */
        "[a-z]".toRegex()
    }


    class DataLogin() {

        val firebase: FirebaseAuth = Firebase.auth
        val email: MutableState<String> = mutableStateOf("")
        val password: MutableState<String> = mutableStateOf("")
        val loading: MutableState<Boolean> = mutableStateOf(false)

        val statusLogin: MutableState<StatusLogin> = mutableStateOf(StatusLogin.AUN_NO_LOGUEADO)
        val statusCreateAccount: MutableState<StatusCreateAccount> = mutableStateOf(StatusCreateAccount.INICIO)

        fun createAccount(email: String, password: String) {

            firebase.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    if (it.isComplete && it.result.user != null) {
                        statusCreateAccount.value = StatusCreateAccount.SI_JALISCO
                    } else {
                        statusCreateAccount.value = StatusCreateAccount.ERROR_GENERAL
                    }
                } else {
                    statusCreateAccount.value = StatusCreateAccount.ERROR_GENERAL
                }
            }
        }

        fun login(email: String, password: String) {
            firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {

                    if (it.isComplete && it.result.user != null) {
                        statusLogin.value = StatusLogin.LOGEADO
                    } else {
                        statusLogin.value = StatusLogin.ERROR_USUARIO_OR_PASSWORD
                    }

//                    it.result.user?.email
                } else {
                    statusLogin.value = StatusLogin.ERROR_DE_RED
                }

                Log.e("TAG", "login: ${statusLogin.value.name}")

            }
        }
    }
}