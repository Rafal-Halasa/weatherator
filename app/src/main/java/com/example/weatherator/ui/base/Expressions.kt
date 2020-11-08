package com.example.weatherator.ui.base

import androidx.core.util.PatternsCompat
import java.util.regex.Pattern

const val REGEX = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*\$"
fun String.isCityValid() = Pattern.compile(REGEX).matcher(this).matches()
