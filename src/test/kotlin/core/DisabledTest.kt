package core

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DisabledTest {

    @Disabled
    @Test
    fun disabledTest() {
        println("Disabled test")
    }
}
