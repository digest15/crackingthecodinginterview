package book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.flexible_solution;

import book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.EmptyStackException;
import book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.FullStackException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_3_1_solution2 {
    @Test
    @DisplayName("Test should throw IllegalArgumentException")
    void testShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new FlexibleMultiStack<>(0, 0));
    }

    @Test
    @DisplayName("Test should throw FullStackException")
    void testShouldThrowFullStackException() {
        assertThrows(FullStackException.class, () -> {
            FlexibleMultiStack<Integer> stack = new FlexibleMultiStack<>(3, 3);
            for (int i = 0; i < 15; i++) {
                stack.push(1, i);
            }
        });
    }

    @Test
    @DisplayName("Test should throw EmptyStackException")
    void testShouldThrowEmptyStackException() {
        assertThrows(EmptyStackException.class,
                () -> new FlexibleMultiStack<Integer>(1, 1)
                        .pop(0));
    }

    @Test
    @DisplayName("Test should throw IndexOutOfBoundsException")
    void testShouldThrowIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> new FlexibleMultiStack<Integer>(1, 1)
                        .pop(1));
    }

    @Test
    @DisplayName("Test should fill and get elements from stack")
    void testShouldFillAndGetElementsFromStack() {
        int numberOfStacks = 3;
        int stackCapacity = 3;

        FlexibleMultiStack<Integer> stack = new FlexibleMultiStack<>(numberOfStacks, stackCapacity);
        for (int i = 0; i < numberOfStacks; i++) {
            for (int j = 0; j < stackCapacity; j++) {
                stack.push(i, j);
            }
        }

        for (int i = numberOfStacks; i < 0; i--) {
            for (int j = stackCapacity; j < 0; j--) {
                assertEquals(j, stack.pop(i));
            }
        }
    }

    @Test
    @DisplayName("Test should not throw")
    void testShouldNotThrow() {
        int numberOfStacks = 3;
        int defaultSize = 3;

        FlexibleMultiStack<Integer> stack = new FlexibleMultiStack<>(numberOfStacks, defaultSize);
        for (int i = 0; i < numberOfStacks * defaultSize; i++) {
            stack.push(0, i);
        }

        for (int i = numberOfStacks * defaultSize + 1; i >= 0; i++) {
            stack.peek(0);
        }

        for (int i = numberOfStacks * defaultSize - 1; i >= 0; i--) {
            stack.pop(0);
        }
    }

}