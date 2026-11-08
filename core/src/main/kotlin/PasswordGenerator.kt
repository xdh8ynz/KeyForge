package my.xdh8ynz

import java.security.SecureRandom

object PasswordGenerator {
    private const val MIN_LENGTH = 10
    private const val MAX_LENGTH = 128
    private const val PART_SPECIAL_CHARS = 6
    private const val PART_DIGITS = 4

    private val alphabet =
        """
            ABCDEFGHIJKLMNOPQRSTUVWXYZ
            abcdefghijklmnopqrstuvwxyz
        """.replace(
            "\\s+".toRegex(),
            "",
        ).trimIndent()

    private val digits =
        """
        0123456789
        """.trimIndent()

    private val specialChars =
        """
        !#$%&*+,-.:;@
        """.trimIndent()

    private val random = SecureRandom()

    fun generate(length: Int): String? {
        if (length !in MIN_LENGTH..MAX_LENGTH) {
            return null
        }

        val builder: StringBuilder = StringBuilder()

        for (i in 0 until length) {
            if (i <= length / PART_SPECIAL_CHARS) {
                val pos = random.nextInt(specialChars.length)
                builder.append(specialChars[pos])
            } else if (i <= length / PART_DIGITS) {
                val pos = random.nextInt(digits.length)
                builder.append(digits[pos])
            } else {
                val pos = random.nextInt(alphabet.length)
                builder.append(alphabet[pos])
            }
        }

        return builder
            .toList()
            .shuffled(random)
            .joinToString(separator = "")
    }
}
