package tinkov_middle.collections.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class User {
    private Long id;
    private String name;
    private List<User> friends = new ArrayList<>();

    public User(String name) {
        this.name = name;
        this.id = new Random().nextLong();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
