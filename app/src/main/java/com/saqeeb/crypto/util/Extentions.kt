package com.saqeeb.crypto.util

fun Long.toTextFormat():String{
    val suffixes = arrayOf("", "K", "M", "B", "T")
    var num = this
    var index = 0

    while (num >= 1000 && index < suffixes.size - 1) {
        num /= 1000
        index++
    }

    return if (index == 0) {
        "$num"
    } else {
        "${num}.${(this % 1000) / 100} ${suffixes[index]}"
    }
}