package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.vo

import java.lang.Exception

sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure<out T>(val exception: Exception) : Resource<T>()

}