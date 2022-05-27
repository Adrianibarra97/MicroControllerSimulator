package instrunctions.simpleInstructions

import instrunctions.Instruction
import microprocessor.Microprocessor

class SUB: Instruction() {
    override fun doExecute(microprocessor: Microprocessor) {
        val subtraction = microprocessor.acumulatorA - microprocessor.acumulatorB

        microprocessor.acumulatorA = subtraction.toByte()
        microprocessor.acumulatorB = 0
    }
}