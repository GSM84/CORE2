package Lesson4.SerialProcess;

public class Main {
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main w = new Main();
            Thread t1 = new Thread(() -> {
                w.printLetter('A', 'B');
            });
            Thread t2 = new Thread(() -> {
                w.printLetter('B', 'C');
            });
            Thread t3 = new Thread(() -> {
                w.printLetter('C', 'A');
            });
            t1.start();
            t2.start();
            t3.start();
    }

    public synchronized  void printLetter(char letter, char nextLetter) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != letter) {
                        wait();
                    }
                    System.out.print(letter);
                    currentLetter = nextLetter;
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
