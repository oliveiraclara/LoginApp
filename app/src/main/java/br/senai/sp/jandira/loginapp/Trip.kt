package br.senai.sp.jandira.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.loginapp.ui.theme.LoginAppTheme

class Trip : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                TripApp()
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {

}

@Preview(showSystemUi = true)
@Composable
fun TripApp() {
    LoginAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Card(modifier = Modifier.fillMaxWidth()
                    .height(360.dp)) {
                    Image(painter = painterResource(id = R.drawable.background), contentDescription = "")
                }
            }
        }
    }
}