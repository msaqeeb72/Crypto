package com.saqeeb.crypto.util

import androidx.compose.ui.graphics.Color
import java.util.Random

object Utils {
    fun generateRandomColor(): Color {
        val rnd = Random()
        return Color(
            android.graphics.Color.argb(
                255,
                (0..256).random(),
                (0..256).random(),
                (0..256).random(),
            )
        )
    }
}