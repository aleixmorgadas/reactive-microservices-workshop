package dev.aleixmorgadas.reactivemicroservicesworkshop.controllers

import dev.aleixmorgadas.reactivemicroservicesworkshop.service.Comment
import dev.aleixmorgadas.reactivemicroservicesworkshop.service.HttpStatusCode
import dev.aleixmorgadas.reactivemicroservicesworkshop.service.ServiceConfigurationService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.slf4j.LoggerFactory
import org.zalando.problem.Problem

@Controller("/api/comments")
class CommentsController(
    private val serviceConfigurationService: ServiceConfigurationService
) {
    private val logger = LoggerFactory.getLogger(CommentsController::class.java)

    @Get("/")
    fun comments(): HttpResponse<Any> {
        return when (serviceConfigurationService.state.httpStatusCode) {
            HttpStatusCode.OK -> {
                logger.info("all good")
                return HttpResponse.ok(
                    listOf(
                        Comment(
                            id = 1,
                            postId = 1,
                            author = "Aleix Morgadas",
                            message = "So good"
                        )
                    )
                )
            }
            HttpStatusCode.INTERNAL_SERVER_ERROR -> {
                logger.error("configured to throw")
                return HttpResponse.serverError(
                    Problem.builder()
                        .withDetail("You configured it to throw")
                        .build()
                )
            }
            HttpStatusCode.TIMEOUT -> {
                Thread.sleep(10000)
                return HttpResponse
                    .status<Any?>(HttpStatus.REQUEST_TIMEOUT)
                    .body(
                        Problem.builder()
                            .withDetail("Timeout")
                            .build()
                    )
            }
        }
    }
}