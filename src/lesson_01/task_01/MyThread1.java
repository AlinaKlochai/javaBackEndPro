package lesson_01.task_01;

public class MyThread1 extends Thread{

    @Override
    public void run(){

        for (int i = 100; i < 110; i++) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
