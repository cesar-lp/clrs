package chapter2

enum class SortMode {
    ASCENDING, DESCENDING
}

fun insertionSort(arr: Array<Int>, sortMode: SortMode = SortMode.ASCENDING) {
    if (arr.size == 1) return

    for (i in 1 until arr.size) {
        val currentValue = arr[i]
        var prevIndex = i - 1

        prevIndex = if (sortMode == SortMode.ASCENDING) {
            sortAscending(prevIndex, arr, currentValue)
        } else {
            sortDescending(prevIndex, arr, currentValue)
        }

        arr[prevIndex + 1] = currentValue
    }
}

private fun sortAscending(prevIndex: Int, sortedArr: Array<Int>, currentValue: Int): Int {
    while (prevIndex >= 0 && sortedArr[prevIndex] > currentValue) {
        sortedArr[prevIndex + 1] = sortedArr[prevIndex]
        return sortAscending(prevIndex - 1, sortedArr, currentValue)
    }

    return prevIndex
}

private fun sortDescending(prevIndex: Int, sortedArr: Array<Int>, currentValue: Int): Int {
    while (prevIndex >= 0 && sortedArr[prevIndex] < currentValue) {
        sortedArr[prevIndex + 1] = sortedArr[prevIndex]
        return sortDescending(prevIndex - 1, sortedArr, currentValue)
    }

    return prevIndex
}
