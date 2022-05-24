package testExecuteProgram

import instrunctions.LODV
import instrunctions.NOP
import instrunctions.SWAP
import microprocessor.Microprocessor
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import microprocessor.MicroprocessorImpl

class TestExecuteProgram: DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Given a microprocessor.") {
        //ARRANGE:
        val microprocessor: Microprocessor = MicroprocessorImpl()

        it("Successfully run the NOP program.") {
            //ACT:
            microprocessor.run(listOf(
                NOP(),
                NOP(),
                NOP(),
            ))

            //ASSERT:
            microprocessor.programCounter.shouldBe(3)
        }

        it("Successfully run the ADD1 program.") {
            //ACT:
            microprocessor.run(listOf(
                LODV(10),
                SWAP(),
                LODV(22),
                ADD()
            ))

            //ASSERT:
            microprocessor.programCounter.shouldBe(4)
            microprocessor.acumulatorA.shouldBe(32)
            microprocessor.acumulatorB.shouldBe(0)
        }

        it("Successfully run the ADD2 program.") {
            //ACT:
            microprocessor.run(listOf(
                LODV(2),
                STR(0),
                LODV(8),
                SWAP(),
                LODV(5),
                ADD(),
                SWAP(),
                LOD(0),
                ADD()
            ))

            //ASSERT:
            microprocessor.programCounter.shouldBe(9)
            microprocessor.acumulatorA.shouldBe(15)
            microprocessor.acumulatorB.shouldBe(0)
        }

        it("Successfully run the ADD3(result grater than one byte) program.") {
            //ACT:
            microprocessor.run(listOf(
                LODV(100),
                SWAP(),
                LODV(50),
                ADD()
            ))

            //ASSERT:
            microprocessor.programCounter.shouldBe(4)
            microprocessor.acumulatorA.shouldBe(127)
            microprocessor.acumulatorB.shouldBe(23)
        }

        it("Successfully run the DIV(try dividing by zero) program.") {
            //ASSERT:
            microprocessor.run(listOf(
                LODV(0),
                SWAP(),
                LODV(2),
                DIV()
            )).shouldBeTypeOf<ArithmeticException>()
            microprocessor.programCounter.shouldBe(4)
        }
    }
})