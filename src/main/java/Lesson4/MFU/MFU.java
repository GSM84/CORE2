package Lesson4.MFU;

public class MFU {
    volatile boolean isPrinting = false;
    volatile boolean isScanning = false;

    public synchronized void print(Consumer _consumer) throws InterruptedException {
        while(isPrinting){
        }
        isPrinting= true;

        System.out.println("Выполняется задание "+ _consumer);
        Thread.sleep(2000);
        System.out.println("Исполнено задание пользователя "+ _consumer.getName() + " " + System.currentTimeMillis());
        isPrinting = false;
    }

    public synchronized void copy(Consumer _consumer) throws InterruptedException {
        while (isPrinting || isScanning) {
        }
        isPrinting = true;
        isScanning = true;

        System.out.println("Выполняется задание "+ _consumer);
        Thread.sleep(3000);
        System.out.println("Исполнено задание пользователя "+ _consumer.getName() + " " + System.currentTimeMillis());
        isScanning = false;
        isPrinting = false;
    }

    public void scan(Consumer _consumer) throws InterruptedException {
        while (isScanning) {
        }
        isScanning= true;

        System.out.println("Выполняется задание "+ _consumer);
        Thread.sleep(1000);
        System.out.println("Исполнено задание пользователя "+ _consumer.getName() + " " + System.currentTimeMillis());
        isScanning = false;
    }

    public void process(Consumer _consumer){
        System.out.println("Получено задание: "+_consumer);
        try {
            switch (_consumer.getTask()){
                case COPY: copy(_consumer);
                           break;
                case SCAN: scan(_consumer);
                           break;
                case PRINT: print(_consumer);
                           break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
