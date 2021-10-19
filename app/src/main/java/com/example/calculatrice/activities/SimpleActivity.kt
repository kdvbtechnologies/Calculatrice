package com.example.calculatrice.activities

import com.example.calculatrice.R

open class SimpleActivity : BaseSimpleActivity() {
    override fun getAppIconIDs() = arrayListOf(
        R.mipmap.ic_icon

    )
    override fun getAppLauncherName() = getString(R.string.app_launcher_name)

}