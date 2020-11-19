package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model

import com.google.gson.annotations.SerializedName

data class PostResponse(

    @SerializedName("description")
    val description: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("temperature")
     val temperature: String
)

fun List<PostResponse>.asCacheModel(): List<Places> {
    return map {
        Places(
            idPlaces = it.id,
            name = it.title,
            image = it.image,
            description = it.description,
            temperature = it.temperature
        )
    }
}