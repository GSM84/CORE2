package Lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private CyclicBarrier cb;
    private CountDownLatch cdl;
    private CountDownLatch beforeStart;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier _cb, CountDownLatch _cdl, CountDownLatch _beforeStart) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = _cb;
        this.cdl = _cdl;
        this.beforeStart = _beforeStart;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            beforeStart.countDown();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (race.getIsFinished().compareAndSet(false, true))
            System.out.println(this.name + " Победил!");
        cdl.countDown();
    }
}