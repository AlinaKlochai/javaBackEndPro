package lesson_01.task_03;

public class MyTread extends Thread{

    @Override
    public void run() {

        for (int i = 0; i < 1_000_000; i++) {
            Main.counter++;
        }
    }
}
