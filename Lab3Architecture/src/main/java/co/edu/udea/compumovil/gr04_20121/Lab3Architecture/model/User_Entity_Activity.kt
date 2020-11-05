package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User_Entity_Activity(
//
//    @ColumnInfo(name = "name")val user: String,
//    @ColumnInfo(name = "passWord")val password: String,
//    @ColumnInfo(name = "email")val email: String,

    val user: String,
    val password: String,
    val email: String,

    @PrimaryKey(autoGenerate = true) val idUser: Int=0

)