package org.kotlin.everywhere.keresult


sealed class Result<out E, out T>

data class Ok<out T>(val value: T) : Result<Nothing, T>()
data class Err<out E>(val error: E) : Result<E, Nothing>()

fun <E, T1, T2> Result<E, T1>.map(mapper: (T1) -> T2): Result<E, T2> {
    return when (this) {
        is Ok -> Ok(mapper(value))
        is Err -> this
    }
}

fun <E1, E2, T> Result<E1, T>.mapError(mapper: (E1) -> E2): Result<E2, T> {
    return when (this) {
        is Ok -> this
        is Err -> Err(mapper(error))
    }
}

