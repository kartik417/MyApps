package com.example.jetpackcompose1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }

    }


}


@Preview(showBackground = true)
@Composable
fun MyApp(){
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background

    )
    {
        signUpPage()
    }


}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun signUpPage(){
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false)}
    var errorMessage by remember { mutableStateOf("")}
    var isLoading by remember { mutableStateOf(false)}
    var showSnackBar by remember { mutableStateOf(false)}
    var snackbarMessage by remember { mutableStateOf("")}
    val passwordStrength = calculatePasswordStrength(password)
    val snackBarHostState = remember { SnackbarHostState() }
    val snackBarScope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val context = LocalContext.current
            // Logo
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Add your app's logo here
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )

            // Title
            Text(
                text = "Sign Up",
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Username Field
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email Field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val iconText = if (passwordVisible) "Hide" else "Show"
                    TextButton(onClick = { passwordVisible = !passwordVisible }) {
                        Text(iconText)
                    }
                }
            )

            // Password Strength Indicator
            Text(
                text = "Password Strength: $passwordStrength",
                color = when (passwordStrength) {
                    "Weak" -> MaterialTheme.colorScheme.error
                    "Medium" -> MaterialTheme.colorScheme.primary
                    "Strong" -> MaterialTheme.colorScheme.tertiary
                    else -> MaterialTheme.colorScheme.onBackground
                },
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Confirm Password Field
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Submit Button
            Button(
                onClick = {
                    // Simulate sign-up process

                    isLoading = true
                    snackBarScope.launch {
                        delay(2000) // Simulate network delay
                        isLoading = false
                        if (username.isEmpty()) {
                            snackbarMessage = "Username cannot be empty"
                        } else if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            snackbarMessage = "Enter a valid email address"
                        } else if (password.isEmpty()) {
                            snackbarMessage = "Password cannot be empty"
                        } else if (password != confirmPassword) {
                            snackbarMessage = "Passwords do not match"
                        } else {
                            snackbarMessage = "Sign-Up Successful!"
                        }
                        snackBarHostState.showSnackbar(snackbarMessage)


                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading,

            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                } else {
                    Text("Sign Up")

                }
            }

            Button(onClick = {
                val intent = Intent(context.applicationContext, SplashScreen::class.java)
                context.startActivity(intent)
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Click Me")
            }
        }
    }
}
fun calculatePasswordStrength(password: kotlin.String): String{
    return when{
        password.isNotEmpty() && password.length < 6  -> "Weak"
        password.any { it.isUpperCase() } && password.any { it.isLowerCase() } && password.any { it.isDigit() && password.length >6 && password.length < 9 } -> "Medium"
        password.length ==9 -> "Strong"
        else -> ""
    }
}




