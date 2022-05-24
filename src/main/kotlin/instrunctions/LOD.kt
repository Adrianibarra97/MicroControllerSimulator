package instrunctions

import microprocessor.Microprocessor

class LOD(val addres: Int): Instruction() {
    override fun doExecute(microprocessor: Microprocessor) {
        microprocessor.acumulatorA = microprocessor.getData(addres)
    }
}