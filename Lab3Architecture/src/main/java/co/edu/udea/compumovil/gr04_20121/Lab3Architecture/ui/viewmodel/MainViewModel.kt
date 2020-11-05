package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain.Repo
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlin.Exception

class MainViewModel(private val repo: Repo):ViewModel(){

    val fetchSitiosList = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
           emit(repo.getSitiosList())
        } catch (e: Exception){
           /*emit(Resource.Failure(e))*/
        }
    }


}