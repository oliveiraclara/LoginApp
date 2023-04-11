package br.senai.sp.jandira.loginapp.gui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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

class SignUpApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val user = User(
//            userName = "Maria",
//            email = "maria@gmail.com",
//            password = "12345",
//            phone = "(11)967688790",
//            isOver18 = true
//        )
//
//        val userRep = UserRepository(this)
//        var id = userRep.save(user)
//
//        Toast.makeText(
//            this,
//            "$id",
//            Toast.LENGTH_LONG
//        ).show()

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

    var userNameState by rememberSaveable {
        mutableStateOf("")
    }
    var phoneState by rememberSaveable {
        mutableStateOf("")
    }
    var emailState by rememberSaveable {
        mutableStateOf("")
    }
    var passwordState by rememberSaveable {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

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
                    OutlinedTextField(value = userNameState, onValueChange = { userNameState = it },
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
                    OutlinedTextField(value = phoneState, onValueChange = { phoneState = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
                    OutlinedTextField(value = emailState, onValueChange = { emailState = it },
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
                    OutlinedTextField(value = passwordState, onValueChange = { passwordState = it },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(16.dp),
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
                        Checkbox(checked = over18State,
                            onCheckedChange = { over18State = it })
                        Text(text = stringResource(id = R.string.over_18))

                    }
                    Button(
                        onClick = {
                            saveUser(
                                userNameState,
                                phoneState,
                                emailState,
                                passwordState,
                                over18State,
                                context
                                )
                        },
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
                        Icon(
                            painter = painterResource(
                                id = R.drawable.arrow_forward_24
                            ),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(31.dp))
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

fun saveUser(
    userName: String,
    phone: String,
    email: String,
    password: String,
    isOver18: Boolean,
    context: Context,
) {
    val newUser = User(
        id = 0,
        userName = userName,
        phone = phone,
        email = email,
        password = password,
        isOver18 = isOver18
    )
    //Criando uma instancia no repositorio
    val userRepository = UserRepository(context)

    //Verificar se o usuario existe
    val user  = userRepository.findUserByEmail(email)
    Log.i("ds2m", "${user.toString()}")

    // Salvar o usuario
    if (user == null){
        val id = userRepository.save(newUser)

        Toast.makeText(
            context,
            "Created User #$id",
            Toast.LENGTH_LONG
        ).show()
    }else{
        Toast.makeText(
            context,
            "User already exists",
            Toast.LENGTH_LONG
        ).show()
    }
}


