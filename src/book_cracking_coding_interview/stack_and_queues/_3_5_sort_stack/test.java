package book_cracking_coding_interview.stack_and_queues._3_5_sort_stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class test {
    @Test
    @DisplayName("Test should get sorted stack")
    void testShouldGetSortedStack() {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(18);
        stack.push(13);

        Solution.sort(stack);

        int buf = stack.pop();
        while (!stack.isEmpty()) {
            if (buf > stack.peek()) {
                fail("Don't correct sort stack");
            }
            buf = stack.pop();
        }
    }
}