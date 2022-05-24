package instrunctions

import microprocessor.Microprocessor

abstract class Instruction() {
    fun execute(microprocessor: Microprocessor) {
        microprocessor.advanceProgram()
        this.doExecute(microprocessor)
    }

    abstract fun doExecute(microprocessor: Microprocessor)
}