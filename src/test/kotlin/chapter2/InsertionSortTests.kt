package chapter2

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class InsertionSortTests {

    companion object {
        @JvmStatic
        fun ascendingOrderTestFixtureGenerator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(2), arrayOf(2)),
                Arguments.of(arrayOf(5, 2), arrayOf(2, 5)),
                Arguments.of(arrayOf(5, 2, 4, 6, 1, 3), arrayOf(1, 2, 3, 4, 5, 6)),
            )
        }

        @JvmStatic
        fun descendingOrderTextFixtureGenerator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf(2), arrayOf(2)),
                Arguments.of(arrayOf(2, 5), arrayOf(5, 2)),
                Arguments.of(arrayOf(5, 2, 4, 6, 1, 3), arrayOf(6, 5, 4, 3, 2, 1)),
            )
        }
    }

    @ParameterizedTest(name = "from {0} to {1}")
    @MethodSource("ascendingOrderTestFixtureGenerator")
    fun `should sort in ascending order`(unsortedArray: Array<Int>, expectedSortedArray: Array<Int>) {
        insertionSort(unsortedArray)

        assertArrayEquals(expectedSortedArray, unsortedArray)
    }

    @ParameterizedTest(name = "from {0} to {1}")
    @MethodSource("descendingOrderTextFixtureGenerator")
    fun `should sort in descending order`(unsortedArray: Array<Int>, expectedSortedArray: Array<Int>) {
        insertionSort(unsortedArray, SortMode.DESCENDING)

        assertArrayEquals(expectedSortedArray, unsortedArray)
    }
}