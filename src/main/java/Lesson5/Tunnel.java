package Lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore sm;
    public Tunnel(int _volume) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.sm = new Semaphore(_volume / 2);

    }
    @Override
    public void go(Car c) {
        try {
            try {
                sm.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                sm.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}