import instrunctions.NOP
import microprocessor.Microprocessor
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
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
    }
})