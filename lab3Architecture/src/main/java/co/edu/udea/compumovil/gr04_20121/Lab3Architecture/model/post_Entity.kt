package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "posts")
class post_Entity (
        val image: String,
        val temperature: String,
        val description: String,
        val title: String,
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0
    ): Serializable

