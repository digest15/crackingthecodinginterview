package tinkov_middle.collections.task2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BoundedPriorityQueue<E> extends PriorityQueue<E> {

    private int maxSize;

    public BoundedPriorityQueue(int maxSize, Comparator<? super E> comparator) {
        super(maxSize + 1, comparator);
        this.maxSize = maxSize;
    }

    @Override
    public boolean offer(E e) {
        boolean result = false;

        if (size() < maxSize || comparator().compare(peek(), e) >= 0) {
            result = super.offer(e);
            if (size() > maxSize) {
                poll();
            }
        }

        return result;
    }
}
