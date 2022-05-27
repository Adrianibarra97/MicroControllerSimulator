package instrunctions.compoundInstructions

import instrunctions.Instruction
import microprocessor.Microprocessor

abstract class CompoundNotZeroInstruction(open val instructions: List<Instruction>) : Instruction() {

    override fun doExecute(microprocessor: Microprocessor) {
        this.operate(microprocessor) { it.run(instructions) }
    }

    fun Microprocessor.notZero() = this.acumulatorA.toInt() == 0

    abstract fun operate(microprocessor: Microprocessor, instructions: (Microprocessor) -> Unit)
}