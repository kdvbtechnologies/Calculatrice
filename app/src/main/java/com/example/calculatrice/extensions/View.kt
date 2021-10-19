package com.example.calculatrice.extensions

import android.view.HapticFeedbackConstants
import android.view.View

fun View.performHapticFeedback() = performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)