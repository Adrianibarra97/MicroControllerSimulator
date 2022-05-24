package testExecuteProgram

import instrunctions.*
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowExactly
import microprocessor.Microprocessor
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import microprocessor.MicroprocessorImpl

class TestExecuteProgram: DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Given a microprocessor.") {
        //ARRANGE:

        // Microprocessors:
        val microprocessor: Microprocessor = MicroprocessorImpl()

        // Instructions:
        val nop = NOP()
        val add = ADD()
        val swap = SWAP()
        val div = DIV()

        it("Successfully run the NOP program.") {
            //ACT:
            microprocessor.run(listOf(nop, nop, nop))

            //ASSERT:
            microprocessor.programCounter.shouldBe(3)
        }

        it("Successfully run the ADD1 program.") {
            //ACT:
            microprocessor.run(listOf(LODV(10), swap, LODV(22), add))

            //ASSERT:
            microprocessor.programCounter.shouldBe(4)
            microprocessor.acumulatorA.shouldBe(32)
            microprocessor.acumulatorB.shouldBe(0)
        }

        it("Successfully run the ADD2 program.") {
            //ACT:
            microprocessor.run(listOf(LODV(2), STR(0), LODV(8), swap,
                LODV(5), add, swap, LOD(0), add))

            //ASSERT:
            microprocessor.programCounter.shouldBe(9)
            microprocessor.acumulatorA.shouldBe(15)
            microprocessor.acumulatorB.shouldBe(0)
        }

        it("Successfully run the ADD3(result grater than one byte) program.") {
            //ACT:
            microprocessor.run(listOf(LODV(100), swap, LODV(50), add))

            //ASSERT:
            microprocessor.programCounter.shouldBe(4)
            microprocessor.acumulatorA.shouldBe(127)
            microprocessor.acumulatorB.shouldBe(23)
        }

        it("Successfully run the DIV(try dividing by zero) program.") {
            //ACT:
            microprocessor.run(listOf(LODV(4), swap, LODV(2), div))

            //ASSERT:
            microprocessor.programCounter.shouldBe(4)
            //microprocessor.acumulatorA.shouldBe(2)
            //microprocessor.acumulatorB.shouldBe(0)
        }

        it("podemos deshacer la instrucción SWAP") {
            //ACT:
            microprocessor.run(listOf(LODV(25), swap))

            //ASSERT:
            microprocessor.programCounter.shouldBe(2)
            microprocessor.acumulatorA.shouldBe(0)
            microprocessor.acumulatorB.shouldBe(25)

            swap.undo(microprocessor)

            microprocessor.programCounter.shouldBe(1)
            microprocessor.acumulatorA.shouldBe(25)
            microprocessor.acumulatorB.shouldBe(0)
        }

    }
})