package chapter2

fun binarySearch(arr: Array<Int>, value: Int): Int {
    var start = 0
    var end = arr.size - 1

    while (start <= end) {
        val mid = start + (end - start) / 2
        val found = arr[mid]

        when {
            found < value -> start = mid + 1
            found > value -> end = mid - 1
            else -> return mid
        }
    }

    return -1
}