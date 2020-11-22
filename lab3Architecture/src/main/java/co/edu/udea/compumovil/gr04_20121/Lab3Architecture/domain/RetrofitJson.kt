package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitJson {

    private const val BASE_URL = "https://my-json-server.typicode.com/Cmorz/JSON-SERVER-04/"

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun poiService(): PostService = retrofit().create(PostService::class.java)
}