package carlose.morales.udea.roomsqlite.Interface

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user_table WHERE idUser = :id")
    fun get(id: Int): LiveData<UserEntity>

    @Query("SELECT * FROM user_table WHERE user = :user")
    fun getUser(user: String): LiveData<UserEntity>

    @Insert
    fun insertAll(vararg user: UserEntity)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}