package book_data_structures_and_algorithms_lofore.stacks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GrowingStackTest {
    private static List<Integer> testList;
    private static final int size = 100;

    @BeforeAll
    static void initTest() {
        testList = Stream.iterate(0, i -> i + 1)
                .limit(size)
                .collect(Collectors.toList());

        //Collections.shuffle(testList);
    }

    @Test
    @DisplayName("Test should throw IllegalArgumentException")
    void testShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new GrowingStack<String>(-1));
    }

    @Test
    @DisplayName("Test should construct new stack and check that it will be empty")
    void testShouldConstructNewStackAndCheckThatItWillBeEmpty() {
        GrowingStack<String> stack = new GrowingStack<>(10);
        assertTrue(stack.isEmpty(), "Stack isn't empty");
    }

    @Test
    @DisplayName("Test should throw NullPointerException when push to stack null")
    void testShouldThrowNullPointerExceptionWhenPushToStackNull() {
        assertThrows(NullPointerException.class, () -> new GrowingStack<String>(10).push(null));
    }

    @Test
    @DisplayName("Test should create stack and check order of elements")
    void testShouldCreateStackAndCheckOrderOfElements() {
        LinkedList<Integer> localTestList = new LinkedList<>(testList);
        GrowingStack<Integer> stack = new GrowingStack<>(localTestList.size());
        localTestList.forEach(i -> stack.push(i));

        Integer first = stack.peek();
        Integer last = null;
        while (!stack.isEmpty()) {
            last = stack.pop();
        }

        assertEquals(localTestList.getFirst(), last);
        assertEquals(localTestList.getLast(), first);
    }

}