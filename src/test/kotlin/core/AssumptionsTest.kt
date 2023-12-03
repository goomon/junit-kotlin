package core

import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Assumptions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AssumptionsTest {

    private val environment = TestsEnvironment(
        System.getProperty("java.vm.specification.version"),
        System.getProperty("os.name")
    )
    @BeforeEach
    fun setUp() {
        assumeTrue(environment.osSpecification == "Mac OS X")
    }

    @Test
    fun assumeTrue() {
        assumingThat({ environment.javaSpecification == "1.8" }) {
            println("assuming test with lambdas")
        }

    }

    @Test
    fun assumeFalse() {
        assumingThat({ environment.javaSpecification == "1.7" }) {
            throw IllegalStateException()
        }
    }

    class TestsEnvironment(
        val javaSpecification: String,
        val osSpecification: String,
    )
}
