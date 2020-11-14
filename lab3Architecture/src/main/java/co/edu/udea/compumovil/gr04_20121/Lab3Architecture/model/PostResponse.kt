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

fun List<PostResponse>.asCacheModel(): List<Sitios> {
    return map {
        Sitios(
            idSitios = it.id,
            nombre = it.title,
            imagen = it.image,
            descripcion = it.description,
            temperatura = it.temperature
        )
    }
}