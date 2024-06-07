package chapter2

fun linearSearch(arr: Array<Int>, value: Int): Int? {
    for (i in arr.indices) {
        if (arr[i] == value) {
            return i
        }
    }

    return null
}