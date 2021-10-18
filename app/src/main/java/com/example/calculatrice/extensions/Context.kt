package com.example.calculatrice.extensions

import android.content.Context
import com.example.calculatrice.helpers.Config

val Context.config: Config get() = Config.newInstance(applicationContext)