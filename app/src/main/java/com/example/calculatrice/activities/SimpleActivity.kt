package com.example.calculatrice.activities

import com.example.calculatrice.R
import com.simplemobiletools.commons.activities.BaseSimpleActivity

open class SimpleActivity : BaseSimpleActivity() {
    override fun getAppIconIDs() = arrayListOf(
        R.mipmap.ic_launcher_purple

    )
    override fun getAppLauncherName() = getString(R.string.app_launcher_name)

}