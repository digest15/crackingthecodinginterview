package tinkov_middle.concurrency.task1.ver3;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private final String name;
    private final List<Leg> legs;
    private Leg currentLeg;
    private int currentLegIndex;

    public Robot(String name) {
        this.name = name;
        this.legs = new ArrayList<>();
    }

    public void addLeg(Leg leg) {
        legs.add(leg);
        if (currentLeg == null) {
            currentLeg = leg;
            currentLegIndex = 0;
        }
    }

    public void nextLeg() {
        currentLegIndex++;
        if (currentLegIndex == legs.size()) {
            currentLegIndex = 0;
        }
        currentLeg = legs.get(currentLegIndex);
    }

    public Leg getCurrentLeg() {
        return currentLeg;
    }
}
