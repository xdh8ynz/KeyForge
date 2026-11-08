import my.xdh8ynz.PasswordGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertNotNull
import org.junit.jupiter.api.assertNull
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PasswordGeneratorTest {
    @ParameterizedTest
    @ValueSource(
        ints = [
            10, 12, 14, 16, 18, 20,
            22, 24, 26, 28, 30, 50, 100, 128,
        ],
    )
    fun evenLengthTest(length: Int) {
        val password: String? = PasswordGenerator.generate(length)
        assertNotNull(password)
        assertEquals(length, password.length)
    }

    @ParameterizedTest
    @ValueSource(
        ints = [
            11, 13, 15, 17, 19, 21, 23, 25,
            27, 29, 31, 99, 127,
        ],
    )
    fun oddLengthTest(length: Int) {
        val password: String? = PasswordGenerator.generate(length)
        assertNotNull(password)
        assertEquals(length, password.length)
    }

    @ParameterizedTest
    @ValueSource(ints = [-10, -8, -5, -4, 0, 129, 130, 1000])
    fun incorrectLengthPassword(length: Int) {
        val password: String? = PasswordGenerator.generate(length)
        assertNull(password)
    }
}
