package dev.aleixmorgadas.reactivemicroservicesworkshop

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
            title = "comments",
            version = "0.0"
    )
)
object Api {
}
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("dev.aleixmorgadas.reactivemicroservicesworkshop")
		.start()
}

