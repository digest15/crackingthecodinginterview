package book_cracking_coding_interview._1_arrays_and_strings._1_1_uniqu_simbol_in_string.solution3;

import book_cracking_coding_interview._1_arrays_and_strings._1_1_uniqu_simbol_in_string.solution1.Solution1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This solution return string that contains only unique symbols
 */
public class Test_Solution3 {
    @Test
    @DisplayName("Should get string with unique symbol")
    void shouldGetStringWithUniqueSymbol() {
        String uniquSimbol = Solution3.getUniqueSymbol("1233qqwwee");

        assertTrue(Solution1.isUniqueSymbolString(uniquSimbol));
    }
}