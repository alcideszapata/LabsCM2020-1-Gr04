package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Sitios


@Dao
interface SitiosDao {
    @Query("SELECT * FROM  sitios")
    fun getAll(): LiveData<List<Sitios>>

    @Query("SELECT * FROM sitios WHERE idSitios = :id")
    fun get(id: Int): LiveData<Sitios>

    @Insert
    fun insertAll(vararg sitios: Sitios)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(post: Sitios)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<Sitios>)

    @Query("DELETE FROM sitios")
    suspend fun deleteAll()

    @Update
    fun update(sitios: Sitios)

}