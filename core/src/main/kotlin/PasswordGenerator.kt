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

        val countSpecial = length / PART_SPECIAL_CHARS
        val countDigit = length / PART_DIGITS
        val countAlpha = length - (countDigit + countSpecial)

        val builder: StringBuilder = StringBuilder()

        repeat(countSpecial) {
            builder.append(
                specialChars[
                    random.nextInt(specialChars.length),
                ],
            )
        }

        repeat(countDigit) {
            builder.append(
                digits[
                    random.nextInt(digits.length),
                ],
            )
        }

        repeat(countAlpha) {
            builder.append(
                alphabet[
                    random.nextInt(alphabet.length),
                ],
            )
        }

        return builder
            .toList()
            .shuffled(random)
            .joinToString(separator = "")
    }
}
