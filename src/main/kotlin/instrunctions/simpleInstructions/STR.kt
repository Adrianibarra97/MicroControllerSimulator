package instrunctions.simpleInstructions

import instrunctions.Instruction
import microprocessor.Microprocessor

class STR(val addres: Int): Instruction() {
    override fun doExecute(microprocessor: Microprocessor) {
        microprocessor.setData(addres, microprocessor.acumulatorA)
    }
}