package book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.fixed_solition;

import book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.EmptyStackException;
import book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.FullStackException;

public class FixedMultiStack<T> {
    private int numberOfStacks;
    private int stackCapacity;
    private T[] values;
    private int[] sizes;

    /**
     * @param numberOfStacks count of stacks
     * @param stackCapacity maximum capacity of every stack
     * @throws IllegalArgumentException if numberOfStacks or stackCapacity is zero
     */
    public FixedMultiStack(int numberOfStacks, int stackCapacity) {
        if (numberOfStacks == 0) {
            throw new IllegalArgumentException("Number of stacks = 0");
        } else if (stackCapacity == 0) {
            throw new IllegalArgumentException("Stack capacity  = 0");
        }

        this.numberOfStacks = numberOfStacks;
        this.stackCapacity = stackCapacity;

        this.sizes = new int[numberOfStacks];
        this.values = ((T[]) new Object[numberOfStacks * stackCapacity]);
    }

    /**
     * Push a value to top of stack by index.
     * This method throws an exception if this stack is full.
     *
     * @param stackNum index of the target stack
     * @throws FullStackException if stack is full
     * @throws IndexOutOfBoundsException if wrong index for target stack
     */
    public void push(int stackNum, T value) {
        if (isFull(stackNum)){
            throw new FullStackException(String.format("Stack %n is full", stackNum));
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /**
     * Retrieves and removes the top of stack by index.
     * This method throws an exception if this stack is empty.
     *
     * @param stackNum index of the target stack
     * @return the top of stack by index
     * @throws EmptyStackException if stack is empty
     * @throws IndexOutOfBoundsException if wrong index for target stack
     */
    public T pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException(String.format("Stack %n is empty", stackNum));
        }
        T value = values[indexOfTop(stackNum)];
        sizes[stackNum]--;

        return value;
    }

    /**
     * Retrieves, but does not remove, the top of stack by index,
     * or returns {@code null} if this stack is empty.
     *
     * @param stackNum index of the target stack
     * @return the top of stack by index, or {@code null} if this stack is empty
     * @throws IndexOutOfBoundsException if wrong index for target stack
     */
    public T peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return null;
        }
        return values[indexOfTop(stackNum)];
    }

    public int getNumberOfStacks() {
        return numberOfStacks;
    }

    /**
     * Check that stack by index is empty
     *
     * @param stackNum index of the target stack
     * @return True if stack by index is empty or else
     * @throws IndexOutOfBoundsException if wrong index for target stack
     */
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    /**
     * Check that stack by index is full
     *
     * @param stackNum index of the target stack
     * @return True if stack by index is full or else
     * @throws IndexOutOfBoundsException if wrong index for target stack
     */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];

        return offset + size - 1;
    }

}
