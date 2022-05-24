package instrunctions

import microprocessor.Microprocessor

abstract class Instruction() {
    lateinit var microprocessorBefore: Microprocessor

    fun undo(microprocessor: Microprocessor) {
        microprocessor.copyFrom(this.microprocessorBefore)
    }

    fun execute(microprocessor: Microprocessor) {
        microprocessorBefore = microprocessor.copy()
        microprocessor.advanceProgram()
        this.doExecute(microprocessor)
    }

    abstract fun doExecute(microprocessor: Microprocessor)
}