package com.example.calculatrice.extensions

import android.widget.TextView

val TextView.value: String get() = text.toString().trim()