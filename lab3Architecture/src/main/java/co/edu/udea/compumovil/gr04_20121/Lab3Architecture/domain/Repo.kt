package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain

import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Places
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.valueObjet.Resource


interface Repo {

    fun getPlacesList(): Resource<List<Places>>



}