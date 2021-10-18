package com.example.calculatrice.helpers

import com.example.calculatrice.R

class CalculatorImpl (calculator : Calculator) {
    private var callback: Calculator? = calculator
    private  var inputDisplayedFormula = "0"

    private fun addDigit(number: Int) {
        if(inputDisplayedFormula == "0") {
            inputDisplayedFormula = ""
        }

    }

    fun handleOperation(operation: String) {
        if(inputDisplayedFormula == Double.NaN.toString()) {
            inputDisplayedFormula = "0"
        }

        if (inputDisplayedFormula == "") {
            inputDisplayedFormula = "0"
        }

    }

    fun numpadClicked(id: Int) {
        if(inputDisplayedFormula == Double.NaN.toString()) {
            inputDisplayedFormula =""
        }

        when(id) {
            R.id.btn_1 -> addDigit(1)
        }
    }
}