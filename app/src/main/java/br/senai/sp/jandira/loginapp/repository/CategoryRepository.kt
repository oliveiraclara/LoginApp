package br.senai.sp.jandira.loginapp.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.model.Category


class CategoryRepository {

    companion object{
        @Composable
        fun getCategories(): List<Category>{
            return listOf(
                Category(id = 1, categoryName = "Mountain", categoryIcon = painterResource(id = R.drawable.mountain)),
                Category(id = 2, categoryName = "Snow", categoryIcon = painterResource(id = R.drawable.snow)),
                Category(id = 3, categoryName = "Beach", categoryIcon = painterResource(id = R.drawable.beach)),
                Category(id = 4, categoryName = "Business", categoryIcon = painterResource(id = R.drawable.briefcase)
            ))
        }
    }
}