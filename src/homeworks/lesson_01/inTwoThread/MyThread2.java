package homeworks.lesson_01.inTwoThread;

public class MyThread2 extends Thread {

    @Override
    public void run() {
        for (int i = 1_000_001; i < 2_000_000; i++) {
            if(i % 21 == 0 && Main.containsNumber3(i)){
                Main.increment();
            }
        }
    }
}
