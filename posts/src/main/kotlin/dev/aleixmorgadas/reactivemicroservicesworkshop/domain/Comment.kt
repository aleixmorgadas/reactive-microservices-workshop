package dev.aleixmorgadas.reactivemicroservicesworkshop.domain

import io.micronaut.core.annotation.Introspected

@Introspected
data class Comment(val id: Long, val author: String, val message: String, val postId: Long)
