package com.example.calculatrice.helpers

import android.content.Context
import com.example.calculatrice.R
import com.example.calculatrice.extensions.getSharedPrefs

open class BaseConfig(val context: Context) {
    protected val prefs = context.getSharedPrefs()
        companion object {

        }

    var vibrateOnButtonPress: Boolean
    get() = prefs.getBoolean(VIBRATE_ON_BUTTON_PRESS, context.resources.getBoolean(R.bool.default_vibrate_on_press))
    set(vibrateOnButton) = prefs.edit().putBoolean(VIBRATE_ON_BUTTON_PRESS, vibrateOnButton).apply()
}