package core

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("DisplayNane on class")
class DisplayNameTest {

    @DisplayName("DisplayName on method")
    @Test
    fun displayName() {
        println("DisplayName test")
    }
}
