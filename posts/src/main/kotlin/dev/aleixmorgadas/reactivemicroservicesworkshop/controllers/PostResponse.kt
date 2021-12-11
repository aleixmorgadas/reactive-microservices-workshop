package dev.aleixmorgadas.reactivemicroservicesworkshop.controllers

import dev.aleixmorgadas.reactivemicroservicesworkshop.domain.Comment
import io.micronaut.core.annotation.Introspected

@Introspected
data class PostResponse(val id: Long, val title: String, val content: String, val comments: List<Comment>)
