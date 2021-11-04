package book_cracking_coding_interview._1_arrays_and_strings._1_1_uniqu_simbol_in_string.solution1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_Solution1 {
    @Test
    @DisplayName("Test should to determine that string contains only unique symbol ")
    void testShouldToDetermineThatStringContainsOnlyUniqueSymbol() {
        assertTrue(Solution1.isUniqueSymbolString("123"));
        assertFalse(Solution1.isUniqueSymbolString("qwe123rrt"));
    }
}