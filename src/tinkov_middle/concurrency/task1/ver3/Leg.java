package tinkov_middle.concurrency.task1.ver3;

import java.util.concurrent.CompletableFuture;

public class Leg implements Runnable {
    private final Robot robot;
    private final String name;

    public Leg(Robot robot, String name) {
        this.robot = robot;
        this.name = name;
        robot.addLeg(this);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (robot) {
                if (robot.getCurrentLeg().equals(this)) {
                    System.out.println(name);
                    robot.nextLeg();
                }
            }
        }
    }

    public static void main(String[] args) {

        Robot vasya = new Robot("Вася");

        CompletableFuture.allOf(
                CompletableFuture.runAsync(new Leg(vasya, "left")),
                CompletableFuture.runAsync(new Leg(vasya, "right")),
                CompletableFuture.runAsync(new Leg(vasya, "back"))
        ).join();
    }
}
