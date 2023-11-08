package com.example.firebase

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firebase.ui.theme.FirebaseTheme


@Composable
fun LoginUI() {
    val viewModel: LoginViewModel = hiltViewModel()
    LoginView(viewModel = viewModel.dataLogin)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(viewModel: LoginViewModel.DataLogin) {
    val context = LocalContext.current

    Scaffold(
        bottomBar = {

        },
        topBar = {

        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
                    .padding(15.dp)
            ) {

                Box(modifier = Modifier.weight(3f)) {
                    Column(modifier = Modifier.align(Alignment.Center)) {

                        Image(
                            painter = painterResource(id = R.drawable.udg),
                            contentDescription = null,
                            modifier = Modifier.size(180.dp).align(CenterHorizontally)
                        )

                        Spacer(modifier = Modifier.size(40.dp))

                        TextField(
                            value = viewModel.email.value,
                            onValueChange = { text ->
                                viewModel.email.value = text
                            },
                            placeholder = {
                                Text(text = "User")
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth()

                        )

                        Spacer(modifier = Modifier.size(10.dp))

                        TextField(
                            value = viewModel.password.value,
                            onValueChange = { text ->
                                viewModel.password.value = text
                            },
                            placeholder = {
                                Text(text = "Password")
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth()

                        )

                        Spacer(modifier = Modifier.size(10.dp))

                        Text(
                            text = "Forgot password?",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }

                Box(modifier = Modifier.weight(1f)) {
                    Column(modifier = Modifier.align(Alignment.BottomEnd)) {
                        Button(
                            onClick = {

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(text = "Sign in")
                        }

                        Text(
                            text = "I Don't have an Account",
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                }
            }
        }
    }

    if (viewModel.loading.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.6f))
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview()
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(device = Devices.AUTOMOTIVE_1024p)
@Preview(device = Devices.AUTOMOTIVE_1024p, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    FirebaseTheme {
        LoginView(LoginViewModel.DataLogin())
    }
}