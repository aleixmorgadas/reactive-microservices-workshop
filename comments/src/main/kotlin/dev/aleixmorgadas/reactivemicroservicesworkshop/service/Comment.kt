package dev.aleixmorgadas.reactivemicroservicesworkshop.service

import io.micronaut.core.annotation.Introspected

@Introspected
data class Comment(
    val postId: String,
    val author: String,
    val message: String
)
