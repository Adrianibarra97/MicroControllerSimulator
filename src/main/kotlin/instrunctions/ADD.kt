package instrunctions

import microprocessor.Microprocessor

class ADD: Instruction() {
    override fun doExecute(microprocessor: Microprocessor) {
        val addition = microprocessor.acumulatorA + microprocessor.acumulatorB
        val maxValue = Byte.MAX_VALUE.toInt()
        val accumulatorA = minOf(addition, maxValue)
        val accumulatorB = maxOf(0, addition - maxValue)

        microprocessor.acumulatorA = accumulatorA.toByte()
        microprocessor.acumulatorB = accumulatorB.toByte()
    }
}