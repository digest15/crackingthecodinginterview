package book_cracking_coding_interview.stack_and_queues._3_2_stack_min.solution2;

import book_cracking_coding_interview.stack_and_queues._3_2_stack_min.solution1.StackWithMinWithNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_3_2 {
    @Test
    @DisplayName("Test should gets all minimum elements")
    void testShouldGetsAllMinimumElements() {
        StackWithMinWithStack<Integer> stackWithMinWithStack = new StackWithMinWithStack<>();

        stackWithMinWithStack.push(5);
        stackWithMinWithStack.push(4);
        stackWithMinWithStack.push(3);
        stackWithMinWithStack.push(6);
        stackWithMinWithStack.push(7);

        assertEquals(3, stackWithMinWithStack.getMin());
        assertEquals(7, stackWithMinWithStack.pop());

        assertEquals(3, stackWithMinWithStack.getMin());
        assertEquals(6, stackWithMinWithStack.pop());

        assertEquals(3, stackWithMinWithStack.getMin());
        assertEquals(3, stackWithMinWithStack.pop());

        assertEquals(4, stackWithMinWithStack.getMin());
        assertEquals(4, stackWithMinWithStack.pop());

        assertEquals(5, stackWithMinWithStack.getMin());
        assertEquals(5, stackWithMinWithStack.pop());
    }
}