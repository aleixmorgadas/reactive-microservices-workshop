package dev.aleixmorgadas.reactivemicroservicesworkshop.domain

import io.micronaut.core.annotation.Introspected

@Introspected
data class Post(val id: Long, val title: String, val content: String)
