package com.example.calculatrice.activities

import androidx.appcompat.app.AppCompatActivity

abstract class BaseSimpleActivity : AppCompatActivity() {
    abstract fun getAppIconIDs() : ArrayList<Int>

    abstract fun getAppLauncherName() : String

}
