package book_cracking_coding_interview.stack_and_queues._3_2_stack_min.solution1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_3_2 {
    @Test
    @DisplayName("Test should gets all minimum elements")
    void testShouldGetsAllMinimumElements() {
        StackWithMinWithNode<Integer> stackWithMinWithNode = new StackWithMinWithNode<>();

        stackWithMinWithNode.push(5);
        stackWithMinWithNode.push(4);
        stackWithMinWithNode.push(3);
        stackWithMinWithNode.push(6);
        stackWithMinWithNode.push(7);

        assertEquals(3, stackWithMinWithNode.getMin());
        assertEquals(7, stackWithMinWithNode.pop());

        assertEquals(3, stackWithMinWithNode.getMin());
        assertEquals(6, stackWithMinWithNode.pop());

        assertEquals(3, stackWithMinWithNode.getMin());
        assertEquals(3, stackWithMinWithNode.pop());

        assertEquals(4, stackWithMinWithNode.getMin());
        assertEquals(4, stackWithMinWithNode.pop());

        assertEquals(5, stackWithMinWithNode.getMin());
        assertEquals(5, stackWithMinWithNode.pop());
    }

}