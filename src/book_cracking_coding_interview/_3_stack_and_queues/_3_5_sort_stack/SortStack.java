package book_cracking_coding_interview._3_stack_and_queues._3_5_sort_stack;

import java.util.Deque;
import java.util.LinkedList;

public class SortStack {
    public static <T extends Comparable<T>> void sort(Deque<T> stack) {
        Deque<T> bufStack = new LinkedList<>();

        while (!stack.isEmpty()) {
            T tmp = stack.pop();
            while (!bufStack.isEmpty() && bufStack.peek().compareTo(tmp) < 0){
                stack.push(bufStack.pop());
            }
            bufStack.push(tmp);
        }

        while (!bufStack.isEmpty()) {
            stack.push(bufStack.pop());
        }
    }
}
