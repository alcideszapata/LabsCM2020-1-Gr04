package co.edu.udea.compumovil.gr04_20201.lab2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import co.edu.udea.compumovil.gr04_20201.lab2.domain.Repo
import co.edu.udea.compumovil.gr04_20201.lab2.vo.Resource
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