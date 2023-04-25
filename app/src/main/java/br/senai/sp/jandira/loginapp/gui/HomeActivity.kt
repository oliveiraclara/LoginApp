package br.senai.sp.jandira.loginapp.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.ui.theme.LoginAppTheme

class Trip : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras

        Log.i("ds2m", "id ")

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
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shape = RectangleShape
                ) {
                    Image(
                        painter = painterResource(id = br.senai.sp.jandira.loginapp.R.drawable.home),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, end = 12.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Image(
                            painter = painterResource(id = br.senai.sp.jandira.loginapp.R.drawable.user),
                            contentDescription = stringResource(id = br.senai.sp.jandira.loginapp.R.string.susanna_description),
                            modifier = Modifier
                                .size(62.dp)
                                .clip(shape = CircleShape)
                                .border(2.dp, Color.White, shape = CircleShape)
                        )
                        Text(
                            text = stringResource(id = br.senai.sp.jandira.loginapp.R.string.susanna_hoffs),
                            modifier = Modifier.padding(top = 6.dp),
                            color = Color.White
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Row() {
                        }
                        Text(
                            text = stringResource(id = br.senai.sp.jandira.loginapp.R.string.my_trips),
                            modifier = Modifier.padding(start = 26.dp, bottom = 10.dp),
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
                Text(text = stringResource(id = br.senai.sp.jandira.loginapp.R.string.categories))
            }
        }
    }
}