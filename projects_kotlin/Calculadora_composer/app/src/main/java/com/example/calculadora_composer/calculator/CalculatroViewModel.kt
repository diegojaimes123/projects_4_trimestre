package com.example.calculadora_composer.calculator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context

class CalculatroViewModel:ViewModel() {

    private val _inputText = mutableStateOf(CalculatorState())
    val inputText : State<CalculatorState> = _inputText

    private val _outputText = mutableStateOf(CalculatorState())
    val outputText : State<CalculatorState> = _outputText

    fun onEvent(e: CalculatorEvent) {
        when (e) {
            CalculatorEvent.AllClear -> allclear()
            CalculatorEvent.BackSpace -> backSpace()
            CalculatorEvent.Calculator -> calculate()
            is CalculatorEvent.Write -> write(e.value)

        }
    }

    private fun allclear() {
        _inputText.value = inputText.value.copy(
            text = ""
        )
        _outputText.value = outputText.value.copy(
            text = ""
        )
    }

    private fun backSpace() {
        val length = _inputText.value.text.length
        if (length > 0 ) {
            _inputText.value = inputText.value.copy(
                text = inputText.value.text.subSequence(0, length - 1) as String
            )
        }

    }

    private fun calculate() {

    }

//    private fun rhinoSetUp (input: String): String {
//        val rhino = Context.enter()
//        rhino.optimizationLevel = -1
//
//        val scripTable = rhino.initSafeStandardObjects()
//        return rhino.evaluateString(
//         scripTable,
//           input.replace("*", "*", "javascript",1,null).toString()
//        )
//
//    }

    private fun write(value : String) {
        _inputText.value = inputText.value.copy(
            text = inputText.value.text + value
        )
    }

}