package book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.flexible_solution;

import book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.EmptyStackException;
import book_cracking_coding_interview._3_stack_and_queues._3_1_three_in_one.FullStackException;

import java.util.ArrayList;

public class FlexibleMultiStack<T> {
    private ArrayList<T> values;
    private ArrayList<StackInfo> stackInfos;
    private int allSize;

    /**
     * @param numberOfStacks count of stacks
     * @param defaultSize maximum capacity of every stack
     * @throws IllegalArgumentException if numberOfStacks or stackCapacity is zero
     */
    public FlexibleMultiStack(int numberOfStacks, int defaultSize) {
        if (numberOfStacks == 0) {
            throw new IllegalArgumentException("Number of stacks = 0");
        } else if (defaultSize == 0) {
            throw new IllegalArgumentException("Stack size  = 0");
        }

        this.allSize = numberOfStacks * defaultSize;
        this.values = new ArrayList<>(allSize);
        for (int i = 0; i < allSize; i++) {
            values.add(null);
        }

        this.stackInfos = new ArrayList<>();
        for (int i = 0; i < numberOfStacks; i++) {
            this.stackInfos.add(new StackInfo(defaultSize * i, defaultSize));
        }
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
        if (allStackAreFull()) {
            throw new FullStackException(String.format("Stack %n is full", stackNum));
        }

        StackInfo stack = stackInfos.get(stackNum);
        if (stack.isFull()) {
            expand(stackNum);
        }

        stack.size++;
        values.set(stack.lastElementIndex(), value);
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
        StackInfo stack = stackInfos.get(stackNum);
        if (stack.isEmpty()) {
            throw new EmptyStackException(String.format("Stack %n is empty", stackNum));
        }

        T value = values.get(stack.lastElementIndex());
        values.set(stack.lastElementIndex(), null);
        stack.size--;

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
        StackInfo stack = stackInfos.get(stackNum);
        return values.get(stack.lastElementIndex());
    }

    private void shift(int stackNum) {
        StackInfo stack = stackInfos.get(stackNum);

        if (stack.size > stack.capacity) {
            int nextStack = (stackNum + 1) % stackInfos.size();
            shift(nextStack);
            stack.capacity++;
        }

        int index = stack.lastCapacityIndex();
        while (stack.isWithinStackCapacity(index)) {
            values.set(index, values.get(previousIndex(index)));
            index = previousIndex(index);
        }

        values.set(stack.start, null);
        stack.start = nextIndex(stack.start);
        stack.capacity--;
    }

    private void expand(int stackNum) {
        shift((stackNum+1)%stackInfos.size());
        stackInfos.get(stackNum).capacity++;
    }

    private boolean allStackAreFull() {
        return numberOfElements() == allSize;
    }

    private int numberOfElements() {
        int size = 0;
        for (StackInfo stack : stackInfos) {
            size += stack.size;
        }

        return size;
    }

    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }

    private int adjustIndex(int index) {
        int max = values.size();
        if (max == 0) {
            return index;
        }
        return ((index % max) + max) % max;
    }

    private class StackInfo {
        public int start;
        public int size;
        public int capacity;

        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        public boolean isWithinStackCapacity(int index) {
            if (index < 0 || index >= values.size()) {
                return false;
            }

            int contigousIndex = index < start ? index + values.size() : index;
            int end = start + capacity;

            return start <= contigousIndex && contigousIndex < end;
        }

        public int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        public boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
