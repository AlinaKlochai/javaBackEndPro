package lesson_01.task_01;

public class Main {

    public static void main(String[] args) {
        // Способы создания потоков:
        // 1. Наследуемся от класса Thread
        // 2. Реализуем интерфейс Runnable

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        // Старт отдельного потока при первом способе
        myThread1.start();

        // Старт отдельного потока при втором способе
        Thread thread = new Thread(myThread2);
        thread.setDaemon(true);
        thread.start();


        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
