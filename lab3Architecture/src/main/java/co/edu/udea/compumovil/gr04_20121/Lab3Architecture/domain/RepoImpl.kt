package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain

import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.DataSource
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Sitios
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {
    override fun getSitiosList(): Resource<List<Sitios>> {
        return dataSource.generateSitiosList
    }
}