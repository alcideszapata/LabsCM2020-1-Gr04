package co.edu.udea.compumovil.gr04_20201.lab2.domain

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import co.edu.udea.compumovil.gr04_20201.lab2.data.model.Sitios



@Dao
interface SitiosDao {
    @Query("SELECT * FROM  sitios")
    fun getAll(): LiveData<List<Sitios>>

    @Query("SELECT * FROM sitios WHERE idSitios = :id")
    fun get(id: Int): LiveData<Sitios>

    @Insert
    fun insertAll(vararg sitios: Sitios)

    @Update
    fun update(sitios: Sitios)


}