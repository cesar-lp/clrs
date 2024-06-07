package chapter2

fun bubbleSort(arr: Array<Int>) {
    val n = arr.size - 1

    for (i in 0..n) {
        for (j in n downTo i + 1) {

            if (arr[j] < arr[j - 1]) {
                val tmp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = tmp
            }
        }
    }
}