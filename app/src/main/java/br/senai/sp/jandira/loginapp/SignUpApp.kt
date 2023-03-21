package br.senai.sp.jandira.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween) {
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Card(
                        modifier = Modifier
                            .width(140.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(bottomStart = 16.dp),
                        backgroundColor = Color(red = 207, green = 6, blue = 240)
                    ) {
                    }
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                    Column() {
                        Text(
                            text = stringResource(id = R.string.sign_up),
                            fontSize = 48.sp,
                            color = Color(red = 207, green = 6, blue = 240),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = stringResource(id = R.string.create_new_account),
                            color = Color(red = 160, green = 156, blue = 156)
                        )
                    }
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
                OutlinedTextField(value = emailUser, onValueChange = { phoneUser = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = stringResource(id = R.string.phone))},
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.phone_24),
                            contentDescription = stringResource(id = R.string.email_description),
                            tint = Color(207, 1, 240)
                        )
                    }
                )
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
                Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 246)),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(text = stringResource(id = R.string.create_account),
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
                }
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
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier
                            .width(140.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(topEnd = 16.dp),
                        backgroundColor = Color(red = 207, green = 6, blue = 240)
                    ) {
                    }
                }
            }
        }
   }
}