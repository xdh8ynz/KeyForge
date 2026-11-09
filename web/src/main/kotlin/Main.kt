package my.xdh8ynz

import io.ktor.http.HttpStatusCode
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respond
import io.ktor.server.response.respondResource
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        routing {
            get("/") {
                call.respondResource("index.html")
            }

            get("/generate") {
                val input = call.queryParameters["length"]
                val length = input?.toIntOrNull()

                if (length == null) {
                    call
                        .respond(
                            HttpStatusCode
                                .BadRequest,
                            message =
                                "Ошибка! Вы ввели некорректное значение длины пароля.",
                        )
                    return@get
                }

                val password = PasswordGenerator.generate(length)

                if (password == null) {
                    call
                        .respond(
                            HttpStatusCode
                                .BadRequest,
                            message =
                                "Ошибка! Не удалось сгенерировать пароль.",
                        )

                    return@get
                }

                return@get call.respond(password)
            }

            get("/ping") {
                call.respondText("pong")
            }
        }
    }.start(wait = true)
}
