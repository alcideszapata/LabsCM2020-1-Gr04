package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "sitios")
data class Sitios (
    val nombre: String = "",
    val imagen: String ="",
    val descripcion: String = "",
    val temperatura: String = "",
    val localizacion: String = "",
    @PrimaryKey(autoGenerate = true)
    val idSitios: Int= 0
): Parcelable