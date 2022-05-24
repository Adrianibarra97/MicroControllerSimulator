package instrunctions

import microprocessor.Microprocessor

class NOP : Instruction() {
    override fun doExecute(microprocessor: Microprocessor) {
        // This method does nothing
    }
}