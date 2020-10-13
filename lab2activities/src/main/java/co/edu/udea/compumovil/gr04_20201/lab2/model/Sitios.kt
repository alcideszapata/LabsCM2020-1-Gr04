package co.edu.udea.compumovil.gr04_20201.lab2.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Sitios (
    val nombre: String = "",
    val imagen: String ="",
    val descripcion: String = ""
):Parcelable