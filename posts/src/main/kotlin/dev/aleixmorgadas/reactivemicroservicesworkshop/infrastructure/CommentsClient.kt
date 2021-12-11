package dev.aleixmorgadas.reactivemicroservicesworkshop.infrastructure

import dev.aleixmorgadas.reactivemicroservicesworkshop.domain.Comment
import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import reactor.core.publisher.Mono

@Client
interface CommentsClient {
    @Get("http://localhost:8081/api/comments?postId={postId}")
    @SingleResult
    fun comments(postId: Long): Mono<List<Comment>>
}