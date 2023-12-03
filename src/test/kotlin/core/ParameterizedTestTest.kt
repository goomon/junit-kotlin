package core

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource

class ParameterizedTestTest {

    @ParameterizedTest
    @ValueSource(shorts = [1, 2, 3, 4])
    fun valueSourceTest(expected: Int) {
        println(expected)
    }

    @ParameterizedTest
    @EnumSource(TestEnum::class)
    fun enumSourceTest(expected: TestEnum) {
        println(expected)
    }

    @ParameterizedTest
    @CsvSource(*["1, mike, NewYork", "2, james, Seattle"])
    fun csvSourceTest(id: Long, name: String, address: String) {
        println("$id: $name($address)")
    }

    // @CsvFileSource(resources = ["/core/parameterizedTest.csv"])
    @ParameterizedTest
    @CsvFileSource(resources = ["parameterizedTest.csv"])
    fun csvFileSourceTest(id: Long, name: String, address: String) {
        println("$id: $name($address)")
    }

    enum class TestEnum {
        ONE, TWO, THREE, FOUR;
    }
}
