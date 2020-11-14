package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain

import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.PostResponse
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Posts_Entity
import retrofit2.Call
import retrofit2.http.GET

interface PostsService {
    @GET("posts")
    suspend fun requestPosts(): List<PostResponse>
}