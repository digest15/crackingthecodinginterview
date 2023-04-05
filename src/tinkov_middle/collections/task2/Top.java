package tinkov_middle.collections.task2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Top {
    public static void main(String[] args) {
        int max = 100;

        List<Post> posts = IntStream.range(1, max)
                .boxed()
                .map(i -> new Post(String.valueOf(i), max - i))
                .collect(Collectors.toList());

        List<Post> top = getTop10(posts);
        System.out.println(top);
    }

    public static List<Post> getTop10(List<Post> posts) {
        int queueSize = 10;

        BoundedPriorityQueue<Post> queue = new BoundedPriorityQueue<>(
                queueSize,
                Comparator.comparingInt(Post::likesCount)
        );
        queue.addAll(posts);

        ArrayList<Post> topList = new ArrayList<>();
        for (int i = 0; i < queueSize; i++) {
            topList.add(queue.poll());
        }

        return topList;
    }

    public static record Post(String text, Integer likesCount) { }
}
