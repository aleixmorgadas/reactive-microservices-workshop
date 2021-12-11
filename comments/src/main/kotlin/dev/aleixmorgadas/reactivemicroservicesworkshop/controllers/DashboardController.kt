package dev.aleixmorgadas.reactivemicroservicesworkshop.controllers

import dev.aleixmorgadas.reactivemicroservicesworkshop.service.ServiceConfiguration
import dev.aleixmorgadas.reactivemicroservicesworkshop.service.ServiceConfigurationService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post
import io.micronaut.views.View

@Controller("/")
class DashboardController(private val serviceConfigurationService: ServiceConfigurationService) {

    @View("home")
    @Get("/")
    fun home() = HttpResponse.ok<Any>()

    @View("service-configuration")
    @Get("/service-configuration")
    fun serviceConfiguration() = HttpResponse.ok(serviceConfigurationService.state)

    @View("service-configuration")
    @Post("/service-configuration")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun serviceConfigurationForm(@Body serviceConfiguration: ServiceConfiguration): HttpResponse<ServiceConfiguration> {
        serviceConfigurationService.state = serviceConfiguration
        return HttpResponse.ok(serviceConfigurationService.state)
    }

    @View("bookmarks")
    @Get("/bookmarks")
    fun bookmarks(@Header("host") host: String) = HttpResponse.ok(mapOf("host" to host.split(":").first()))
}