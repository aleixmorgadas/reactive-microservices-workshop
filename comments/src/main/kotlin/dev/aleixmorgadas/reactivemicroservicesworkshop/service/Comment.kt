package dev.aleixmorgadas.reactivemicroservicesworkshop.service

import io.micronaut.core.annotation.Introspected

@Introspected
data class Comment(
    val id: Long,
    val postId: Long,
    val author: String,
    val message: String
)
