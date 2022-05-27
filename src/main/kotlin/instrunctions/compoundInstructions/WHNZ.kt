package instrunctions.compoundInstructions

import instrunctions.Instruction
import microprocessor.Microprocessor

class WHNZ(instructions: List<Instruction>) : CompoundNotZeroInstruction(instructions) {

    override fun operate(micro: Microprocessor, instructions: (Microprocessor) -> Unit) {
        while (micro.notZero()) instructions.invoke(micro)
    }
}