package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.base.AppDatabase
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain.RetrofitFactory
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Sitios
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.repository.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PostsRepository
    var allPosts: LiveData<List<Sitios>> = MutableLiveData()

    init {
        val dao = AppDatabase.getDatabase(application, viewModelScope).sitios()
        val apiService = RetrofitFactory.postService()
        repository = PostsRepository(dao, apiService)
        allPosts = repository.allPosts
//        requestPosts()
    }

    fun requestPosts() {
        // Coroutine that will be canceled when the ViewModel is cleared.
        viewModelScope.launch {
            requestRemotePosts()
        }
    }

    private suspend fun requestRemotePosts() {
        return withContext(Dispatchers.IO) {
            repository.refreshPost()
        }
    }

    /**
     * Launching a new coroutine to delete the data in a non-blocking way
     */
    fun deletePosts() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}