package br.senai.sp.jandira.loginapp.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.model.Category
import br.senai.sp.jandira.loginapp.repository.CategoryRepository
import br.senai.sp.jandira.loginapp.repository.TripRepository
import br.senai.sp.jandira.loginapp.model.Trip
import br.senai.sp.jandira.loginapp.ui.theme.LoginAppTheme
import androidx.compose.material.OutlinedTextField as OutlinedTextField

class Trip : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.extras

        Log.i("ds2m", "id ")

        setContent {
            LoginAppTheme {
                Column {
                    HomeScreen(
                        CategoryRepository.getCategories(),
                        TripRepository.getTrips()
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    categories: List<Category>,
    trips: List<Trip>,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RectangleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
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
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = stringResource(id = R.string.susanna_description),
                        modifier = Modifier
                            .size(62.dp)
                            .clip(shape = CircleShape)
                            .border(2.dp, Color.White, shape = CircleShape)
                    )
                    Text(
                        text = stringResource(id = R.string.susanna_hoffs),
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
                        text = stringResource(id = R.string.my_trips),
                        modifier = Modifier.padding(start = 26.dp, bottom = 10.dp),
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Text(
                text = stringResource(id = R.string.categories),
                color = Color(56, 54, 54),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            var cidades = listOf("Cotia", "Itapevi", "Jandira", "Barueri", "Carapicuíba")
            LazyRow() {
                items(categories) {
                    Card(
                        modifier = Modifier
                            .size(width = 109.dp, height = 100.dp)
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        backgroundColor = Color(207, 6, 246)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(painter = it.categoryIcon, contentDescription = it.categoryName)
                            Text(
                                text = it.categoryName,
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
            OutlinedTextField(
                value = "", onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                placeholder = {
                    Text(text = stringResource(id = R.string.search))
                },
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "")
                    }
                }
            )
            Text(text = stringResource(id = R.string.past_trip),
            fontSize = 14.sp,
            color = Color(86, 86, 84),
            modifier = Modifier.padding(16.dp))
            LazyColumn() {
                items(trips){
                    Card(modifier = Modifier.fillMaxWidth()
                        .padding(16.dp),
                    backgroundColor = Color.Cyan) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Image(painter = painterResource(id = R.drawable.no_photography), contentDescription = "")
                            Text(text = "${it.location}, ${it.startDate.year}")
                            Text(text = it.description)
                            Text(text = "${it.startDate} - ${it.endDate}",
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TripApp() {
    LoginAppTheme {
        HomeScreen(CategoryRepository.getCategories(),
        TripRepository.getTrips())
    }
}