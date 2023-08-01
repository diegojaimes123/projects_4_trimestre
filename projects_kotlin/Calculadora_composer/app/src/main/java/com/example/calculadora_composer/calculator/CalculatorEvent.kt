package com.example.calculadora_composer.calculator

sealed class CalculatorEvent {
    object BackSpace: CalculatorEvent()
    object AllClear: CalculatorEvent()
    object Calculator: CalculatorEvent()
    class Write(val value: String): CalculatorEvent()
}
