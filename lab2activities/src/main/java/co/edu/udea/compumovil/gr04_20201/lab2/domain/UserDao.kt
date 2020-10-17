package carlose.morales.udea.roomsqlite.Interface

import androidx.lifecycle.LiveData
import androidx.room.*
import carlose.morales.udea.roomsqlite.Entity.User_Entity_Activity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAll(): LiveData<List<User_Entity_Activity>>

    @Query("SELECT * FROM user_table WHERE idUser = :id")
    fun get(id: Int): LiveData<User_Entity_Activity>

    @Insert
    fun insertAll(vararg user: User_Entity_Activity)

    @Update
    fun update(user: User_Entity_Activity)

    @Delete
    fun delete(user: User_Entity_Activity)

}