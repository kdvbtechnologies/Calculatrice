package com.example.calculatrice.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.calculatrice.BuildConfig
import com.example.calculatrice.R
import com.example.calculatrice.extensions.appLaunched
import com.example.calculatrice.extensions.config
import com.example.calculatrice.extensions.performHapticFeedback
import com.example.calculatrice.extensions.value
import com.example.calculatrice.helpers.*
import kotlinx.android.synthetic.main.activity_main.*
import me.grantland.widget.AutofitHelper

class MainActivity : SimpleActivity(), Calculator {

    private var vibrateOnButtonPress = true
    lateinit var calc : CalculatorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appLaunched(BuildConfig.APPLICATION_ID)

        calc = CalculatorImpl(this, applicationContext)

        btn_minus.setOnClickListener{ calc.handleOperation(MINUS); checkHaptic(it) }
        btn_plus.setOnClickListener{ calc.handleOperation(PLUS); checkHaptic(it) }
        btn_multiply.setOnClickListener{ calc.handleOperation(MULTIPLY); checkHaptic(it) }
        btn_divide.setOnClickListener{ calc.handleOperation(DIVIDE); checkHaptic(it) }
        btn_percent.setOnClickListener{ calc.handleOperation(PERCENT); checkHaptic(it) }
        btn_power.setOnClickListener{ calc.handleOperation(POWER); checkHaptic(it) }
        btn_root.setOnClickListener{ calc.handleOperation(ROOT); checkHaptic(it) }


        btn_clear.setOnClickListener{ calc.handleClear(); checkHaptic(it) }
        btn_clear.setOnLongClickListener{ calc.handleReset(); true }

        getButtonIds().forEach {
            it.setOnClickListener { calc.numpadClicked(it.id); checkHaptic(it) }
        }
        btn_equals.setOnClickListener { calc.handleEquals(); checkHaptic(it)}
        formula.setOnLongClickListener { copyToClipboard (false) }
        result.setOnLongClickListener { copyToClipboard (true) }

        AutofitHelper.create (formula)
        AutofitHelper.create (result)

    }


    private fun launchSettings() {
        startActivity(Intent(applicationContext,SettingsActivity::class.java))
    }

    private fun getButtonIds() = arrayOf(btn_decimal, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9)


    private fun copyToClipboard(copyResult: Boolean): Boolean {
        var value = formula.value
        if (copyResult) {
            value = result.value
        }

        return if (value.isEmpty()) {
            false
        } else {
            copyToClipboard(value)
            true
        }
    }

    fun Context.copyToClipboard(text: String) {

    }

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

    override fun showNewFormula(value: String, context: Context) {
        formula.text = value
    }

    override fun showNewResult(value: String, context: Context) {
        result.text = value
    }





}