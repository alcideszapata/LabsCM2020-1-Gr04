package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "placesTable")
data class Places (
    val name: String = "",
    val image: String ="",
    val description: String = "",
    val temperature: String = "",
    val localization: String = "",
    @PrimaryKey(autoGenerate = true)
    val idPlaces: Int= 0
): Parcelable