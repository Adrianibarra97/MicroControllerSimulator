import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec

class TestExecuteProgram: DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("Given a microprocessor.") {
        //ARRANGE:
        val micro: Microprocessor = MicroprocessorImpl()

        it("Successfully run the NOP program.") {
            //ACT:
            micro.run(listOf(
                NOP(),
                NOP(),
                NOP(),
            ))

            //ASSERT:
            micro.programCounter.shouldBeExactly(3)
        }
    }
})