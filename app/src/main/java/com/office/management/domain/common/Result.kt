package com.office.management.domain.common

/**
 * Created by Abhinay on 08/01/26.
 */

sealed class Result<out T> {
    data class Success<T>(val data: T): Result<T>()
    data class Error(val message: String, val exception: Throwable? = null): Result<Nothing>()
    data object Loading: Result<Nothing>()
}