package microprocessor

import instrunctions.Instruction
import memory.MemoryMB

class MicroprocessorImpl: Microprocessor, Cloneable {
    private val memory: MemoryMB = MemoryMB()

    override var acumulatorA: Byte = 0
    override var acumulatorB: Byte = 0
    override var programCounter: Byte = 0

    override fun run(program: List<Instruction>) {
        program.forEach { instruction -> instruction.execute(this) }
    }

    override fun advanceProgram() {
        val pc: Int = this.programCounter.toInt() + 1
        this.programCounter = pc.toByte()
    }

    override fun reset() {
        this.programCounter = 0
    }

    override fun getData(address: Int): Byte {
        return memory.data[address]
    }

    override fun setData(address: Int, value: Byte) {
        memory.data[address] = value
    }

    override fun copy(): Microprocessor {
        val microprocessor: Microprocessor = MicroprocessorImpl()

        microprocessor.programCounter = this.programCounter
        microprocessor.acumulatorA = this.acumulatorA
        microprocessor.acumulatorB = this.acumulatorB

        return microprocessor
    }

    override fun copyFrom(other: Microprocessor) {
        this.programCounter = other.programCounter
        this.acumulatorA = other.acumulatorA
        this.acumulatorB = other.acumulatorB
    }
}