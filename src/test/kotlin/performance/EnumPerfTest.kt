package performance

import org.junit.jupiter.api.Test
import util.measureMs

class EnumPerfTest {

    private val cnt = 1000000000

    @Test
    fun valueOf() {
        val elapsed = measureMs(cnt) {
            EnumSut.valueOf("ETC_ERROR")
        }
        println("[valueOf] elapsed: $elapsed ms")
    }

        @Test
    fun ofCodeWithValues() {
        val elapsed = measureMs(cnt) {
            EnumSut.ofCodeWithValues("99")
        }
        println("[ofCodeWithValues] elapsed: $elapsed ms")
    }

    @Test
    fun ofCodeWithEntries() {
        val elapsed = measureMs(cnt) {
            EnumSut.ofCodeWithEntries("99")
        }
        println("[ofCodeWithEntries] elapsed: $elapsed ms")
    }

    @Test
    fun ofCodeByMap() {
        val elapsed = measureMs(cnt) {
            EnumSut.ofCodeByMap("99")
        }
        println("[ofCodeByMap] elapsed: $elapsed ms")
    }

    @Test
    fun ofNameByMap() {
        val elapsed = measureMs(cnt) {
            EnumSut.ofNameByMap("ETC_ERROR")
        }
        println("[ofNameByMap] elapsed: $elapsed ms")
    }
}

enum class EnumSut(val code: String) {
    ZERO("00"),
    ONE("01"),
    TWO("02"),
    THREE("03"),
    FOUR("04"),
    FIVE("05"),
    SIX("06"),
    SEVEN("07"),
    EIGHT("08"),
    NINE("09"),
    TEN("10"),
    ETC_ERROR("99"),
    ;

    companion object {
        fun ofCodeWithValues(code: String): EnumSut {
            return values().firstOrNull { it.code == code } ?: ETC_ERROR
        }

        fun ofCodeWithEntries(code: String): EnumSut {
            return entries.firstOrNull { it.code == code } ?: ETC_ERROR
        }

        private val codeMap: Map<String, EnumSut> = entries.associateBy { it.code }
        private val nameMap: Map<String, EnumSut> = entries.associateBy { it.name }

        fun ofCodeByMap(code: String): EnumSut {
            return codeMap[code] ?: ETC_ERROR
        }

        fun ofNameByMap(name: String): EnumSut {
            return nameMap[name] ?: ETC_ERROR
        }
    }
}
