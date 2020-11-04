package co.edu.udea.compumovil.gr04_20201.lab2.domain

import co.edu.udea.compumovil.gr04_20201.lab2.data.model.Sitios
import co.edu.udea.compumovil.gr04_20201.lab2.vo.Resource

interface Repo {

    fun getSitiosList(): Resource<List<Sitios>>



}