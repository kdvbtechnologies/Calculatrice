package com.example.calculatrice.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.calculatrice.BuildConfig
import com.example.calculatrice.R
import com.example.calculatrice.extensions.config
import com.example.calculatrice.helpers.Calculator
import com.example.calculatrice.helpers.CalculatorImpl
import com.example.calculatrice.helpers.MULTIPLY
import com.simplemobiletools.commons.extensions.appLaunched
import com.simplemobiletools.commons.extensions.performHapticFeedback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : SimpleActivity(), Calculator {

    private var vibrateOnButtonPress = true
    lateinit var calc : CalculatorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appLaunched(BuildConfig.APPLICATION_ID)

        calc = CalculatorImpl(this)

        btn_multiply.setOnClickListener{ calc.handleOperation(MULTIPLY); checkHaptic(it) }

        getButtonIds().forEach {
            it.setOnClickListener { calc.numpadClicked(it.id); checkHaptic(it) }
        }

    }

    private fun launchSettings() {
        startActivity(Intent(applicationContext,SettingsActivity::class.java))
    }

    private fun getButtonIds() = arrayOf(btn_1)

    override fun onResume() {
        super.onResume()

        vibrateOnButtonPress = config.vibrateOnButtonPress
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.settings -> launchSettings()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun checkHaptic(view: View) {
        if(vibrateOnButtonPress) {
            view.performHapticFeedback()
        }
    }



}