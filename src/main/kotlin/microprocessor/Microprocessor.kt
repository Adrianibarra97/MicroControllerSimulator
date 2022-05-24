package microprocessor

import instrunctions.Instruction

interface Microprocessor {
    var acumulatorA: Byte
    var acumulatorB: Byte
    var programCounter: Byte

    fun run(program: List<Instruction>)
    fun advanceProgram()
    fun reset()
    fun getData(address: Int): Byte
    fun setData(address: Int, value: Byte): Byte
    fun copy(): Microprocessor
    fun copyFrom(other: Microprocessor)
}