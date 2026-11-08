package my.xdh8ynz

fun main() {
    println(greeting)
    println()

    while (true) {
        println(request)

        readlnOrNull()
            .let {
                if (it == null || it == EXIT_ESCAPE) {
                    return
                }

                it.toIntOrNull()
            }.let {
                if (it == null) {
                    println(incorrectLengthMessage)
                    continue
                }

                PasswordGenerator
                    .generate(it)
            }.let {
                if (it == null) {
                    println(errorMessage)
                    println(catSadAscii)
                    println()
                } else {
                    println(successfulMessage)
                    println(it)
                    println(catFunAscii)
                    println()
                }
            }
    }
}

private val greeting =
    """
    --------------------------------------------------------------------
    Добро пожаловать! Приложение KeyForge позволит Вам сгенерировать 
    надёжный пароль. Вам всего лишь нужно ввести желаемую 
    длину: от 10 до 128 символов.
    --------------------------------------------------------------------
    """.trimIndent()

private const val EXIT_ESCAPE = "q"

private val request =
    """
    Введите длину пароля: от 10 до 128 символов.
    Чтобы выйти, нажмите $EXIT_ESCAPE.
    """.trimIndent()

private val incorrectLengthMessage =
    """
    Вы ввели некорректную длину!
    """.trimIndent()

private val successfulMessage =
    """
    Пароль успешно сгенерирован!
    """.trimIndent()

private val errorMessage =
    """
    Не удалось сгенерировать пароль!
    """.trimIndent()

private val catSadAscii =
    """
    /ᐠ ╥ ˕ ╥マ
    """.trimIndent()

private val catFunAscii =
    """
     ╱|、
    (˚ˎ 。7  
     |、˜〵          meow~
     じしˍ,)ノ
    """.trimIndent()
