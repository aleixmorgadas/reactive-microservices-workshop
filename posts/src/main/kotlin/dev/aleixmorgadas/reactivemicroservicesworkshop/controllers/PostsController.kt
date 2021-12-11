package dev.aleixmorgadas.reactivemicroservicesworkshop.controllers

import dev.aleixmorgadas.reactivemicroservicesworkshop.infrastructure.CommentsClient
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import reactor.core.publisher.Mono

@Controller("/api/posts")
class PostsController(private val commentsClient: CommentsClient) {

    @Get()
    fun posts(): Mono<List<PostResponse>> {
        return commentsClient.comments(1L)
            .switchIfEmpty(Mono.error(RuntimeException()))
            .mapNotNull {
                listOf(
                    PostResponse(
                        id = 1,
                        title = "Reactive Microservice Workshop",
                        "aleixmorgadas.dev",
                        it
                    )
                )
            }
    }
}