package book_cracking_coding_interview._1_arrays_and_strings._1_3_urlify.solution1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_Solution1 {
    @Test
    @DisplayName("Test should return a correct string")
    void testShouldReturnACorrectString() {
        assertEquals(
                "Hello%20world%20I'm%20a%20programmer",
                Solution1.replaceSpaces("Hello world I'm a programmer            ")
        );
    }

}