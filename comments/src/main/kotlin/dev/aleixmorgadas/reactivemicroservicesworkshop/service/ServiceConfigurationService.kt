package dev.aleixmorgadas.reactivemicroservicesworkshop.service

import jakarta.inject.Singleton

@Singleton
class ServiceConfigurationService {
    var state = ServiceConfiguration(httpStatusCode = HttpStatusCode.OK)
}