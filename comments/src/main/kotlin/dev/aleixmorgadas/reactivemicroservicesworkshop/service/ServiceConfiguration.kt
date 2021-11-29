package dev.aleixmorgadas.reactivemicroservicesworkshop.service

import io.micronaut.core.annotation.Introspected

enum class HttpStatusCode {
    OK,
    INTERNAL_SERVER_ERROR,
    TIMEOUT
}

@Introspected
data class ServiceConfiguration(
    val httpStatusCode: HttpStatusCode
)
