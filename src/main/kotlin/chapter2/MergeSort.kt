package chapter2

fun mergeSort(arr: Array<Int>, start: Int, end: Int) {
    if (arr.isEmpty() || start >= end) return

    require(start >= 0 && start < arr.size)
    require(end > 0 && end < arr.size)

    val mid = (start + end) / 2

    mergeSort(arr, start, mid)
    mergeSort(arr, mid + 1, end)
    merge(arr, start, mid, end)
}

private fun merge(arr: Array<Int>, start: Int, middle: Int, end: Int) {
    val lLength = middle - start + 1
    val rLength = end - middle

    val lSlice = IntArray(lLength)
    val rSlice = IntArray(rLength)

    for (i in 0 until lLength) {
        lSlice[i] = arr[start + i]
    }

    for (i in 0 until rLength) {
        rSlice[i] = arr[middle + i + 1]
    }

    var lIndex = 0
    var rIndex = 0
    var arrIndex = start

    while (lIndex < lLength && rIndex < rLength) {
        if (lSlice[lIndex] <= rSlice[rIndex]) {
            arr[arrIndex] = lSlice[lIndex]
            lIndex++
        } else {
            arr[arrIndex] = rSlice[rIndex]
            rIndex++
        }

        arrIndex++
    }

    while (lIndex < lLength) {
        arr[arrIndex] = lSlice[lIndex]
        lIndex++
        arrIndex++
    }

    while (rIndex < rLength) {
        arr[arrIndex] = rSlice[rIndex]
        rIndex++
        arrIndex++
    }
}