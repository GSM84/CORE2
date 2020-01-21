package Lesson4.MFU;

public class Main {
    public static void main(String[] args) {
        MFU mfu = new MFU();

        Thread c1 = new Thread(new Consumer("Ivanov", Tasks.PRINT, mfu));
        Thread c2 = new Thread(new Consumer("Petrov", Tasks.PRINT, mfu));
        Thread c3 = new Thread(new Consumer("Sidorov", Tasks.SCAN, mfu));
        Thread c4 = new Thread(new Consumer("Fedorov", Tasks.COPY, mfu));
        Thread c5 = new Thread(new Consumer("Egorov", Tasks.SCAN, mfu));

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

    }
}
