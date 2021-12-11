package dev.aleixmorgadas.reactivemicroservicesworkshop.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.views.View

@Controller("/")
class DashboardController() {

    @View("home")
    @Get("/")
    fun home() = HttpResponse.ok<Any>()

    @View("bookmarks")
    @Get("/bookmarks")
    fun bookmarks(@Header("host") host: String) = HttpResponse.ok(mapOf("host" to host.split(":").first()))
}