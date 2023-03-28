package br.senai.sp.jandira.loginapp.model

import androidx.room.Entity

@Entity(tableName = "table_user")
data class User(
    var id: Long = 0,
    var userName: String = "",
    var email: String = "",
    var password: String = "",
    var phone: String ="",
    var isOver18: Boolean = false
)
