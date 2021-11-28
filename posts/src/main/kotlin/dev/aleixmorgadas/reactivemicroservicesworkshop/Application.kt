package dev.aleixmorgadas.reactivemicroservicesworkshop

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("dev.aleixmorgadas.reactivemicroservicesworkshop")
        .start()
}

