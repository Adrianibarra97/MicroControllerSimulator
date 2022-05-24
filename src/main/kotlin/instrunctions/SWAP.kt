package instrunctions

import microprocessor.Microprocessor

class SWAP: Instruction() {
    override fun doExecute(microprocessor: Microprocessor) {
        var assistant: Byte = microprocessor.acumulatorA
        microprocessor.acumulatorA = microprocessor.acumulatorB
        microprocessor.acumulatorB = assistant
    }
}