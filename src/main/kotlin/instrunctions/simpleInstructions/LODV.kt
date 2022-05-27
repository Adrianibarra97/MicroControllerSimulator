package instrunctions.simpleInstructions

import instrunctions.Instruction
import microprocessor.Microprocessor

class LODV(private val value: Byte): Instruction() {
    override fun doExecute(microprocessor: Microprocessor) {
        microprocessor.acumulatorA = this.value
    }
}