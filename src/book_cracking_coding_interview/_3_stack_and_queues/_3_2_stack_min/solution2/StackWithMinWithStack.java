package book_cracking_coding_interview._3_stack_and_queues._3_2_stack_min.solution2;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackWithMinWithStack<T extends Comparable<T>> {
    private LinkedList<T> stack = new LinkedList<>();
    private LinkedList<T> stackMin = new LinkedList<>();

    public void push(T value) {
        T min = stackMin.peek();
        if (min == null || value.compareTo(min) < 0) {
            stackMin.push(value);
        }
        stack.push(value);
    }

    /**
     * Retrieves and removes the top of this stack.
     * This method throws an exception if this stack is empty.
     *
     * @return the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public T pop() {
        try {
            T min = stackMin.peek();
            T value = stack.pop();
            if (min != null && value.compareTo(min) == 0) {
                stackMin.pop();
            }
            return value;
        } catch (NoSuchElementException e) {
            throw new EmptyStackException();
        }
    }

    /**
     * Get min element of this stack.
     * This method throws an exception if this stack is empty.
     *
     * @return min element of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public T getMin() {
        T min = stackMin.peek();
        if (min == null) {
            throw new EmptyStackException();
        }
        return min;
    }
}
