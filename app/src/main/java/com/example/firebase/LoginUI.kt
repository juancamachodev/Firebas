package com.example.firebase

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firebase.ui.theme.FirebaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginIU(){

    val viewModel: LoginViewModel = hiltViewModel()

    Column {
        Icon(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )

        TextField(value = viewModel.email.value, onValueChange = {
            viewModel.email.value = it
        })

        TextField(value = viewModel.password.value, onValueChange = {
            viewModel.password.value = it
        })

        Button(onClick = {}) {
            viewModel.login(viewModel.email.value, viewModel.password.value)
        }
    }
}
@Preview
@Composable
fun preview(){
    FirebaseTheme {
        LoginIU()
    }
}