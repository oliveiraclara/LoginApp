package br.senai.sp.jandira.loginapp.gui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.components.BottonShape
import br.senai.sp.jandira.loginapp.components.TopShape
import br.senai.sp.jandira.loginapp.model.User
import br.senai.sp.jandira.loginapp.repository.UserRepository
import br.senai.sp.jandira.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

}

@SuppressLint("SuspiciousIndentation")
@Preview(showSystemUi = true)
@Composable
fun LoginScreen() {

    val context = LocalContext.current

    var emailUser by rememberSaveable {
        mutableStateOf("")
    }
    var passwordUser by rememberSaveable {
        mutableStateOf("")
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TopShape()
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Column() {
                    Text(
                        text = stringResource(id = R.string.title),
                        fontSize = 48.sp,
                        color = Color(red = 207, green = 6, blue = 240),
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = stringResource(id = R.string.please_sign_up),
                        color = Color(red = 160, green = 156, blue = 156)
                    )
                }
                Spacer(modifier = Modifier.height(85.dp))
                OutlinedTextField(value = emailUser, onValueChange = { emailUser = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = { Text(text = stringResource(id = R.string.email)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email_24),
                            contentDescription = stringResource(id = R.string.email_description),
                            tint = Color(207, 1, 240)
                        )
                    },
                colors= TextFieldDefaults
                    .outlinedTextFieldColors(
                        focusedBorderColor = Color(207, 1, 240),
                        unfocusedBorderColor = Color(207, 1, 240)
                )
                )
                Spacer(modifier = Modifier.height(31.dp))
                OutlinedTextField(value = passwordUser, onValueChange = { passwordUser = it },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock_24),
                            contentDescription = stringResource(id = R.string.email_description),
                            tint = Color(207, 1, 240)
                        )
                    },
                    colors= TextFieldDefaults
                        .outlinedTextFieldColors(
                            focusedBorderColor = Color(207, 1, 240),
                            unfocusedBorderColor = Color(207, 1, 240)
                        )
                )
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = { login(emailUser, passwordUser, context) },
                        modifier = Modifier
                            .width(134.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 246)),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id = R.string.sign_in),
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.arrow_forward_24
                                ),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(42.dp))
                    Row() {
                        Text(
                            text = stringResource(id = R.string.not_have_account),
                            color = Color(red = 160, green = 156, blue = 156),
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = stringResource(id = R.string.sign_up),
                            modifier = Modifier.clickable {
                            val openSignUp = Intent(context, SignUpApp::class.java)
                                context.startActivity(openSignUp)
                            },
                            color = Color(red = 207, green = 6, blue = 240),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                     BottonShape()
                }
            }
        }

    }
}

fun login(email: String, password: String, context: Context) {

    val userRepository = UserRepository(context)
    val user  = userRepository.authenticate(email, password)

    // Fazer login do usuario
    if (user == null){

        Toast.makeText(
            context,
            "email or password is invalid",
            Toast.LENGTH_LONG
        ).show()
    }else{
        Toast.makeText(
            context,
            "Welcome",
            Toast.LENGTH_LONG
        ).show()
        val intent = Intent(context, Trip::class.java)
        intent.putExtra("id", user.id)
        intent.putExtra("name", user.userName)
        context.startActivity(intent)
    }
}
