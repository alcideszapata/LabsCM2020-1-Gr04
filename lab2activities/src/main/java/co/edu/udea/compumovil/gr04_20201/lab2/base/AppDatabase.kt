package co.edu.udea.compumovil.gr04_20201.lab2.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import carlose.morales.udea.roomsqlite.Entity.User_Entity_Activity
import carlose.morales.udea.roomsqlite.Interface.UserDao
import co.edu.udea.compumovil.gr04_20201.lab2.data.model.Sitios
import co.edu.udea.compumovil.gr04_20201.lab2.domain.SitiosDao



@Database(entities = [Sitios::class, User_Entity_Activity::class], version = 3)
 abstract class AppDatabase: RoomDatabase() {

    abstract fun sitios(): SitiosDao

    abstract fun UserDao(): UserDao

    companion object{

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance=
                INSTANCE

            if(tempInstance!= null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance

                return instance
            }

        }
    }

}