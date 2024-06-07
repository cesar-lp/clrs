package chapter2

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class BinarySearchTests {

    companion object {
        @JvmStatic
        fun textFixtureGenerator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(2), 2, 0),
                Arguments.of(arrayOf(2, 7, 8, 12, 150, 244, 256, 300, 1090, 258), 12, 3),
                Arguments.of(arrayOf(2, 7, 8, 12, 150, 244, 256, 300, 1090, 258), 1089, -1),
            )
        }
    }

    @ParameterizedTest(name = "arr {0}, value {1}, idx {2}")
    @MethodSource("textFixtureGenerator")
    fun shouldGetExpectedValue(arr: Array<Int>, value: Int, expectedValue: Int?) {
        assertEquals(expectedValue, binarySearch(arr, value))
    }
}