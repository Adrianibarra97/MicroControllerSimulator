package microprocessor

import instrunctions.Instruction

class MicroprocessorImpl: Microprocessor {
    override var acumulatorA: Byte = 0
    override var acumulatorB: Byte = 0
    override var programCounter: Byte = 0

    override fun run(program: List<Instruction>) {
        program.forEach { instruction -> instruction.execute(this) }
    }

    override fun advanceProgram() {
        this.programCounter.inc()
    }

    override fun reset() {
        this.programCounter = 0
    }

    override fun getData(address: Int): Byte {
        TODO("Not yet implemented")
    }

    override fun setData(address: Int, value: Byte): Byte {
        TODO("Not yet implemented")
    }

    override fun copy(): Microprocessor {
        TODO("Not yet implemented")
    }

    override fun copyFrom(other: Microprocessor) {
        TODO("Not yet implemented")
    }
}