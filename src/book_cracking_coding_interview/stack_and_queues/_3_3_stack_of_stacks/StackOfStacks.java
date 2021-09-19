package book_cracking_coding_interview.stack_and_queues._3_3_stack_of_stacks;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackOfStacks<T> {
    private LinkedList<LinkedList<T>> stacks = new LinkedList<>();
    private int capacity;
    private int numberOfStacks;

    /**
     * @throws IllegalArgumentException if capacity is zero
     */
    public StackOfStacks(int capacity) {
        if (capacity == 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }

    public void push(T element) {
        LinkedList<T> lastStack = stacks.peekLast();
        if (lastStack == null || lastStack.size() == capacity) {
            lastStack = new LinkedList<>();
            stacks.add(lastStack);
            numberOfStacks++;
        }
        lastStack.add(element);
    }

    /**
     * Retrieves and removes the top of this stack.
     * This method throws an exception if this stack is empty.
     *
     * @return the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    public T pop(){
        LinkedList<T> lastStack = stacks.peekLast();
        if (lastStack == null) {
            throw new EmptyStackException();
        }

        T element = lastStack.removeLast();

        if (lastStack.isEmpty()) {
            stacks.removeLast();
            numberOfStacks--;
        }

        return element;
    }

    public int numberOfStacks() {
        return numberOfStacks;
    }

    /**
     * Retrieves and removes the top of underlying stack by index.
     * This method throws an exception if this stack is empty.
     *
     * @return the top of stack by index
     * @throws IndexOutOfBoundsException -
     */
    public T popAt(int index) {
        return shiftElements(index, true);
    }

    private T shiftElements(int index, boolean removeTop) {
        LinkedList<T> stack = stacks.get(index);

        T element;
        if (removeTop) {
            element = stack.removeLast();
        } else {
            element = stack.removeFirst();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
            numberOfStacks--;
        } else if (stacks.size() > index + 1) {
            T tmp = shiftElements(index + 1, false);
            stack.add(tmp);
        }

        return element;
    }
}
