package tinkov_middle.collections.task4;

import java.util.*;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<User> searchForFriendsInWidth(User me, String name) {
        return searchForFriends(me, name, true);
    }

    @Override
    public List<User> searchForFriendsInDepth(User me, String name) {
        return searchForFriends(me, name, false);
    }


    /**
     * Search user in graph by name
     * @param me init note for search
     * @param name Name for search
     * @param inWidth {@code true} - search in width, {@code false} - search in depth
     * @return List of founded users, or empty list if nothing found
     */
    private List<User> searchForFriends(User me, String name, boolean inWidth) {
        Deque<User> deque = new ArrayDeque<>();
        deque.add(me);

        User currentUser;
        List<User> result = new ArrayList<>();
        Set<User> visited = new HashSet<>();

        while (!deque.isEmpty()) {
            currentUser = inWidth ? deque.pollFirst() : deque.pollLast();

            System.out.println(currentUser.getName());
            if (currentUser.getName().equals(name)) {
                result.add(currentUser);
            }

            visited.add(currentUser);
            deque.addAll(currentUser.getFriends());
            deque.removeAll(visited);
        }

        return result;
    }

}
