package instrunctions.compoundInstructions

import instrunctions.Instruction
import microprocessor.Microprocessor

class IFNZ(instructions: List<Instruction>) : CompoundNotZeroInstruction(instructions) {

    override fun operate(micro: Microprocessor, instructions: (Microprocessor) -> Unit) {
        if (micro.notZero()) instructions.invoke(micro)
    }
}