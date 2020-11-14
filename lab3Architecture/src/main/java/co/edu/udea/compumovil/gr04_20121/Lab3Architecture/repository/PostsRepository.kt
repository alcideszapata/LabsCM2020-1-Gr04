package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.repository

import androidx.lifecycle.LiveData
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain.PostsService
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain.SitiosDao
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.PostResponse
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Posts_Entity
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Sitios
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.asCacheModel

class PostsRepository (
    private val postDao: SitiosDao,
    private val apiService: PostsService
) {
    // Room executes all queries on a separate thread.
    var allPosts: LiveData<List<Sitios>> = postDao.getAll()

    suspend fun deleteAll() {
        postDao.deleteAll()
    }

    suspend fun insert(post: Sitios) {
        postDao.insert(post)
    }

    suspend fun refreshPost() {
        val postResponse = apiService.requestPosts()
        postDao.insertPosts(postResponse.asCacheModel())
    }
}




