package book_cracking_coding_interview._1_arrays_and_strings._1_1_uniqu_simbol_in_string.solution2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_Solution2 {
    @Test
    @DisplayName("Test should to determine that string contains only unique symbol ")
    void testShouldToDetermineThatStringContainsOnlyUniqueSymbol() {
        assertTrue(Solution2.isUniqueSymbolString("123"));
        assertFalse(Solution2.isUniqueSymbolString("qwe123rrt"));

        assertTrue(Solution2.isUniqueSymbolStringWithBitSet("123"));
        assertFalse(Solution2.isUniqueSymbolStringWithBitSet("qwe123rrt"));
    }
}