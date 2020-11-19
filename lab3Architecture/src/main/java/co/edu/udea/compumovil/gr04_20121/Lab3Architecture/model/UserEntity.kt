package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    val user: String,
    val password: String,
    val email: String,
    @PrimaryKey(autoGenerate = true) val idUser: Int = 0
)