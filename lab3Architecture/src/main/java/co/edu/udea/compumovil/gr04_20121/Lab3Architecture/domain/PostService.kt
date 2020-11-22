package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain

import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.post_Entity
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("poi")
    fun requestPoi(): Call<List<post_Entity>>

}