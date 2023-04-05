package tinkov_middle.collections.task1;

import java.util.*;

public class Winner {
    public static void main(String[] args) {
        List<String> competitors = List.of(
                "Ivan 5", "Petr 3", "Alex 10", "Petr 8", "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1"
        );
        showWinner1(competitors);
        showWinner2(competitors);
    }

    public static void showWinner1(List<String> competitors){
        Map<String, Rating> scores = new HashMap<>();
        for (int i = 0; i < competitors.size(); i++) {
            String[] tuple = competitors.get(i).split(" ");
            var key = tuple[0];
            var score = Integer.valueOf(tuple[1]);
            var index = i;

            scores.compute(key, (k, v) -> (v == null)
                    ? new Rating(index, score)
                    : new Rating(index, v.score + score)
            );
        }

        Queue<Map.Entry<String, Rating>> queue = new PriorityQueue<>(
                scores.size(),
                (o1, o2) -> {
                    int i = Integer.compare(o1.getValue().score, o2.getValue().score) * -1;
                    if (i == 0) {
                        i = Integer.compare(o1.getValue().order, o2.getValue().order);
                    }
                    return i;
                });
        queue.addAll(scores.entrySet());

        System.out.println(queue.peek());
    }

    private static record Rating(int order, int score) { }

    public static void showWinner2(List<String> competitors) {
        Map<String, Integer> statistics = new LinkedHashMap<>(16, 0.75f, true);

        int maxScore = 0;
        int currentScore = 0;
        for (String competitor : competitors) {
            String[] parts = competitor.split(" ");
            currentScore = statistics.compute(parts[0],
                    (k, v) -> ((v == null) ? 0 : v) + Integer.parseInt(parts[1]));
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }

        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            if (entry.getValue() == maxScore) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }

}
