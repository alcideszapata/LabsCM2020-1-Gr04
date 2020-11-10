package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain

import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Sitios
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.vo.Resource


interface Repo {

    fun getSitiosList(): Resource<List<Sitios>>



}