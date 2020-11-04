package co.edu.udea.compumovil.gr04_20201.lab2.domain

import co.edu.udea.compumovil.gr04_20201.lab2.data.model.DataSource
import co.edu.udea.compumovil.gr04_20201.lab2.data.model.Sitios
import co.edu.udea.compumovil.gr04_20201.lab2.vo.Resource
import co.edu.udea.compumovil.gr04_20201.lab2.domain.Repo

class RepoImpl(private val dataSource: DataSource): Repo {
    override fun getSitiosList(): Resource<List<Sitios>> {
        return dataSource.generateSitiosList
    }
}