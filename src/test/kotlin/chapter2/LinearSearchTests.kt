package chapter2

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class LinearSearchTests {

    companion object {
        @JvmStatic
        fun textFixtureGenerator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(2), 2, 0),
                Arguments.of(arrayOf(5, 2), 1, null),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("textFixtureGenerator")
    fun shouldGetExpectedValue(arr: Array<Int>, value: Int, expectedValue: Int?) {
        assertEquals(expectedValue, linearSearch(arr, value))
    }
}