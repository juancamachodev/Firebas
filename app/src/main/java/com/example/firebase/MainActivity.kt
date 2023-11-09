package com.example.firebase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebase.ui.theme.FirebaseTheme
import com.example.firebase.ui.theme.Home
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    fun verificarUsuarioLogueado(): String?{
        val sharedPreferences = getSharedPreferences("FirebaseLogin", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("USUARIO", null)
        return email
    }

    fun guardarUsuario(email: String){
        val sharedPreferences = getSharedPreferences("FirebaseLogin", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("USUARIO", email).apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userEmail = verificarUsuarioLogueado()



        val viewModel = LoginViewModel()
        viewModel.dataLogin.login("corre", "contra")

        setContent {
            FirebaseTheme {
                if (viewModel.dataLogin.statusLogin.value == LoginViewModel.StatusLogin.LOGEADO){
                    guardarUsuario(viewModel.dataLogin.email.value)
                    //startActivity(Intent(this, Home::class.java))
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(text = userEmail?: "No user")
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseTheme {
        Greeting("Android")
    }
}