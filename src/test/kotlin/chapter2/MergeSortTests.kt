package chapter2

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MergeSortTests {

    companion object {
        @JvmStatic
        fun ascendingOrderTestFixtureGenerator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(emptyArray<Int>(), emptyArray<Int>()),
                Arguments.of(arrayOf(2), arrayOf(2)),
                Arguments.of(arrayOf(5, 2), arrayOf(2, 5)),
                Arguments.of(arrayOf(12, 3, 7, 9, 14, 6, 11, 2), arrayOf(2, 3, 6, 7, 9, 11, 12, 14)),
            )
        }
    }

    @ParameterizedTest(name = "from {0} to {1}")
    @MethodSource("ascendingOrderTestFixtureGenerator")
    fun `should sort in ascending order`(unsortedArray: Array<Int>, expectedSortedArray: Array<Int>) {
        mergeSort(unsortedArray, 0, unsortedArray.size - 1)

        assertArrayEquals(expectedSortedArray, unsortedArray)
    }
}