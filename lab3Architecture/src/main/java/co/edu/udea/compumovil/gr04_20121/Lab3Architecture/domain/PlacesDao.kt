package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Places


@Dao
interface PlacesDao {
    @Query("SELECT * FROM  placesTable")
    fun getAll(): LiveData<List<Places>>

    @Query("SELECT * FROM placesTable WHERE idPlaces = :id")
    fun get(id: Int): LiveData<Places>

    @Insert
    fun insertAll(vararg placesTable: Places)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(post: Places)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<Places>)

    @Query("DELETE FROM placesTable")
    suspend fun deleteAll()

    @Update
    fun update(places: Places)

}