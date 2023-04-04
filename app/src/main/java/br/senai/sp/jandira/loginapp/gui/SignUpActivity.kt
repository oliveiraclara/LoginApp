package br.senai.sp.jandira.loginapp.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.components.BottonShape
import br.senai.sp.jandira.loginapp.components.TopShape
import br.senai.sp.jandira.loginapp.ui.theme.LoginAppTheme

class SignUpApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                SignIn()
            }
        }
    }
}


@Composable
fun Greeting2(name: String) {

}

@Preview(showSystemUi = true)
@Composable
fun SignIn() {

    var userName by rememberSaveable {
        mutableStateOf("")
    }
    var phoneUser by rememberSaveable {
        mutableStateOf("")
    }
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
            Column(
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TopShape()
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontSize = 34.sp,
                        color = Color(red = 207, green = 6, blue = 240),
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = stringResource(id = R.string.create_new_account),
                        fontSize = 18.sp,
                        color = Color(red = 160, green = 156, blue = 156)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Box(
                    modifier = Modifier.size(100.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.BottomEnd),
                        shape = CircleShape,
                        backgroundColor = Color(232, 232, 232, 255)
                    ) {
                        Image(
                            painter = painterResource
                                (id = R.drawable.user),
                            contentDescription = ""
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.add_a_photo_24),
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.BottomEnd)
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    OutlinedTextField(value = emailUser, onValueChange = { emailUser = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        label = { Text(text = stringResource(id = R.string.user_name)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.person_24),
                                contentDescription = stringResource(id = R.string.email_description),
                                tint = Color(207, 1, 240)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(value = emailUser, onValueChange = { phoneUser = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = { Text(text = stringResource(id = R.string.phone)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.phone_24),
                                contentDescription = stringResource(id = R.string.email_description),
                                tint = Color(207, 1, 240)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
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
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(value = emailUser, onValueChange = { emailUser = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        label = { Text(text = stringResource(id = R.string.password)) },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock_24),
                                contentDescription = stringResource(id = R.string.email_description),
                                tint = Color(207, 1, 240)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(checked = false, onCheckedChange = {})
                        Text(text = stringResource(id = R.string.over_18))

                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 246)),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.create_account),
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(31.dp))

                    Row(modifier = Modifier.align(Alignment.End)) {
                        Text(
                            text = stringResource(id = R.string.have_account),
                            color = Color(red = 160, green = 156, blue = 156),
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            //modifier = Modifier.clickable {
                            // val intent = Intent(context, SignUpActivity)
                            //},
                            color = Color(red = 207, green = 6, blue = 240),
                            fontWeight = FontWeight.Bold
                        )
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
    }
}