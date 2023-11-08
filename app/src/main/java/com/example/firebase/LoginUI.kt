package com.example.firebase

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firebase.ui.theme.FirebaseTheme

@Composable
fun LoginUI(){

    val viewModel: LoginViewModel = hiltViewModel()

    Column {
        Icon(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null )

        //TextField(value = viewModel.email.value, onValueChange = {
          //  viewModel.email.value=it
        //})

        //TextField(value = viewModel.password.value, onValueChange ={
      //      viewModel.email.value=it
        //} )

        Button(onClick = { }) {

        }
    }

}

@Preview
@Composable
fun preview(){
    FirebaseTheme {
        LoginUI()
    }
}


