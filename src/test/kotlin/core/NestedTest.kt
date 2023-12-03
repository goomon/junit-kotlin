package core

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class NestedTest {

    private val test = "test"

    @Test
    fun upperClassTest() {
        println("upper class")
    }

    @Nested
    inner class NestedClass {

        @Test
        fun innerClassTest() {
            println("inner class test")
        }

        @Test
        fun innerClassAccessTest() {
            println("outer value access: $test")
        }
    }
}
