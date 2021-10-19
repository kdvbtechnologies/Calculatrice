package com.example.calculatrice.helpers

import android.content.Context

class Config(context: Context) : BaseConfig(context) {
    companion object {
        fun newInstance(context: Context) = Config(context)
    }
}