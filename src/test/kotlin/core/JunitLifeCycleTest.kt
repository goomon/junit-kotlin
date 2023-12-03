package core

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class JunitLifeCycleTest {

    @BeforeEach
    fun setUp() {
        test.add(0)
    }

    @AfterEach
    fun tearDown() {
        test.add(1)
    }

    @Test
    fun test1() {
        println("sample test")
    }

    @Test
    fun test2() {
        println("sample test")
    }

    companion object {
        val test = mutableListOf<Int>()

        @JvmStatic
        @BeforeAll
        fun setUpClass() {
            println("[BeforeAll] size of list: ${test.size}")
        }

        @JvmStatic
        @AfterAll
        fun tearDownClass() {
            println("[AfterAll] size of list: ${test.size}")
        }
    }
}
