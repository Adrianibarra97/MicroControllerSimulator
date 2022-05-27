package instrunctions.simpleInstructions

import instrunctions.Instruction
import microprocessor.Microprocessor

class DIV: Instruction() {
    override fun doExecute(microprocessor: Microprocessor) {
        if(microprocessor.acumulatorB == 0.toByte()) throw ArithmeticException()
        val division = microprocessor.acumulatorA.toInt() / microprocessor.acumulatorB.toInt()

        microprocessor.acumulatorA = division.toByte()
        microprocessor.acumulatorB = 0
    }
}